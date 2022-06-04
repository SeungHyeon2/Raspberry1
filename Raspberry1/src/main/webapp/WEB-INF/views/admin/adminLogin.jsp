<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.83.1">
<link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Noto+Serif+KR:wght@300&display=swap" rel="stylesheet">
<title></title>
<style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
      html,
body {
  height: 100%;
}

body {
  display: flex;
  align-items: center;
  padding-top: 40px;
  padding-bottom: 40px;
  background-color: #f5f5f5;
}

.form-signin {
  width: 100%;
  max-width: 330px;
  padding: 15px;
  margin: auto;
}

.form-signin .checkbox {
  font-weight: 400;
}

.form-signin .form-floating:focus-within {
  z-index: 2;
}

.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
</style>

</head>
<body class="text-center">
    
<main class="form-signin">
  
    <img class="mb-4" src="data:image/png;base64,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" alt="" width="140" height="100">
    <h1 class="h3 mb-3 fw-normal">관리자 로그인</h1>
	<form action ='${pageContext.request.contextPath}/admin/adminManagement' method="post">
    <div class="form-floating">
      <input type="email" class="form-control" id="floatingInput" name="admin_id" placeholder="name@example.com">
      <label for="floatingInput">아이디</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="admin_pw">
      <label for="floatingPassword">비밀번호</label>
    </div>

    <div class="checkbox mb-3">
      <label>
        <input type="checkbox" value="remember-me"> 아이디 기억
      </label>
    </div>
    <button class="w-100 btn btn-lg btn-primary" type="submit">로그인</button>
    <p class="mt-5 mb-3 text-muted">&copy; 택배크로스</p>
  </form>
</main>
</body>
</html>