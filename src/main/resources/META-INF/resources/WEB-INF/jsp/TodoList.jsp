<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<h1>Your Tasks are ::</h1>
	<table class="table">
		<thead>
			<tr>
				<th>Task</th>
				<th>Target Date</th>
				<th>Is Achieved</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<th>${todo.task}</th>
					<th>${todo.dueDate}</th>
					<th>${todo.complete}</th>
					<th><a href="delete-task?id=${todo.id}"
						class="btn btn-warning">Delete</a></th>
					<th><a href="update-task?id=${todo.id}"
						class="btn btn-success">Modify</a></th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="add-todo" class="btn btn-success"> Create Task </a>
</div>

<%@ include file="common/footer.jspf"%>