<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<h1>Login to Todo Application</h1>
	<pre>${InvalidUser}</pre>
	<form:form method="POST" modelAttribute="todo">
		<fieldset class="mb-3">
		</fieldset>
			Name : <input name="name" type="text" required="required" />
		<fieldset class="mb-3">
			Password : <input name="password" type="password" required="required" />
		</fieldset>
		<input type="submit" class="btn btn-success" value="Login" />
	</form:form>

<%@ include file="common/footer.jspf"%>