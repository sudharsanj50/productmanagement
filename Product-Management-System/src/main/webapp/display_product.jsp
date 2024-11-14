<%@page import="net.bytebuddy.utility.privilege.GetSystemPropertyAction"%>
<%@page import="java.util.List"%>
<%@page import="com.example.product.entity.ProductEntity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Page</title>
</head>
<body>

	<%
	List<ProductEntity> products = (List<ProductEntity>) request.getAttribute("product");
	%>

	<table border="2px">

		<thead>
			<tr>
				<td>Product-ID</td>
				<td>TITLE</td>
				<td>DESCRIPTION</td>
				<td>QUANTITY</td>
				<td>PRICE</td>
				<td>EDIT</td>
				<td>DELETE</td>
			</tr>

		</thead>
		<tbody>

			<%
			for (ProductEntity product : products) {
			%>
			<tr>
				<td><%=product.getProductId()%></td>
				<td><%=product.getTitle()%></td>
				<td><%=product.getDescription()%></td>
				<td><%=product.getQuantity()%></td>
				<td><%=product.getPrice()%></td>
				<td><a href="update-product?product_id=<%= product.getProductId() %>">edit</a></td>
				<td><a href="delete-product?product_id=<%=product.getProductId()%>">delete</a></td>
			</tr>

			<%
			}
			%>
		</tbody>
	</table>

</body>
</html>
