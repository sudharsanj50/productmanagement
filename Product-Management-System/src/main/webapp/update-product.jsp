<%@ page import="java.util.List" %>
<%@ page import="com.example.product.entity.ProductEntity" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Page</title>
</head>
<body>
	<%
       ProductEntity product= (ProductEntity)request.getAttribute("products");
   %>
   <h1>Enter product Details</h1>
   
   
   
   <form action="update-product" method="post">
   <input type="number" value="<%=product.getProductId()%>" name="productId" readonly="readonly" ><br>
   <input type="text" value="<%=product.getTitle()%>" name="title" placeholder="Enter Product Title"><br>
   <input type="text" value="<%=product.getDescription()%>" name="description" placeholder="Enter Product Description"><br>
   <input type="number" value="<%=product.getQuantity()%>" name="quantity" placeholder="Enter Product Quantity"><br>
   <input type="number" value="<%=product.getPrice()%>" name="price" placeholder="Enter Product Price"><br>
   
   <input type="submit" value="UPDATE">
   </form>
 
</body>
</html>