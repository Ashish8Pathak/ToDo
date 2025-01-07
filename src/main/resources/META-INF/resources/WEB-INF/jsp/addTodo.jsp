<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<h1>Add/Update a task in Todo List</h1>
	<form:form method="POST" modelAttribute="todo">

		<fieldset class="mb-3">
			<form:label path="task">Description</form:label>
			<form:input type="text" path="task" required="required" />
			<form:errors path="task" cssClass="text-warning" />
		</fieldset>
		<fieldset class="mb-3">
			<form:label path="dueDate">Target Date</form:label>
			<form:input type="text" path="dueDate" required="required" />
			<form:errors path="dueDate" cssClass="text-warning" />
		</fieldset>
		
		<form:input type="hidden" path="complete"/>
		<input type="submit" class="btn btn-success" value="ADD"/>
	</form:form>
</div>
	<%@ include file="common/footer.jspf"%>

	<script type="text/javascript">
		$('#dueDate').datepicker({
			format : 'dd-mm-yyyy'
		});
	</script>