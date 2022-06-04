package controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ParcelProject.exception.ParcelKeepException;
import ParcelProject.service.ParcelKeepService;
import ParcelProject.vo.KeepRequest;

@Controller
@RequestMapping(value = "/courier/keep")
public class KeepController {
	@Resource(name="parcelKeepService")
	ParcelKeepService parcelKeepService;
	
	@GetMapping()
	public String keepGet() {
		return "courier/keep";
	}
	
	@PostMapping()
	public String keepPost(KeepRequest keepRequest, Errors errors, Model model) {
		try {
			parcelKeepService.insertParcel(keepRequest);
			
			//소켓통신 시작
			try (Socket client = new Socket()) {	
				  // 소켓에 접속하기 위한 접속 정보를 선언한다.	
				  InetSocketAddress ipep = new InetSocketAddress("192.168.0.13", 5766);	
				  // 소켓 접속!	
				  client.connect(ipep);	
				  // 소켓이 접속이 완료되면 inputstream과 outputstream을 받는다.	
				  try (OutputStream sender = client.getOutputStream(); InputStream receiver = client.getInputStream();) {		
				    
					// 전송할 메시지를 작성한다.	
				    String msg = "Sending message";	
				    // string을 byte배열 형식으로 변환한다.	
				    byte[] data = msg.getBytes();	
				    // ByteBuffer를 통해 데이터 길이를 byte형식으로 변환한다.	
				    ByteBuffer b = ByteBuffer.allocate(4);	
				    // byte포멧은 little 엔디언이다.	
				    b.order(ByteOrder.LITTLE_ENDIAN);	
				    b.putInt(data.length);	
				    // 데이터 길이 전송	
				    sender.write(b.array(), 0, 4);	
				    // 데이터 전송	
				    sender.write(data);	
				   	
				    data = new byte[4];	
				    // 데이터 길이를 받는다.	
				    receiver.read(data, 0, 4);	
				    // ByteBuffer를 통해 little 엔디언 형식으로 데이터 길이를 구한다.	
				    ByteBuffer buff = ByteBuffer.wrap(data);	
				    buff.order(ByteOrder.LITTLE_ENDIAN);	
				    int length = buff.getInt();	
				    // 데이터를 받을 버퍼를 선언한다.	
				    data = new byte[length];	
				    // 데이터를 받는다.	
				    receiver.read(data, 0, length);	
				      	
				    // byte형식의 데이터를 string형식으로 변환한다.	
				    msg = new String(data, "UTF-8");	
				    // 콘솔에 출력한다.	
				    //System.out.println(msg);
				    String temp_pw = msg.substring(0, 4);
				    model.addAttribute("temp_pw", temp_pw);
				    System.out.println(temp_pw);
				  
				  }	
				} catch (Throwable e) {	
				  e.printStackTrace();	
				}
			//
			
			
			return "home/main";
		} catch (ParcelKeepException ex) {
			ex.printStackTrace();
			return "home/main";
		}catch (Exception ex) {
			ex.printStackTrace();
			return "home/main";
		}

	}
}
