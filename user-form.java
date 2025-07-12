<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Management App</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .card {
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        header {
            background-color: #dc3545;
        }
        header .navbar-brand {
            font-weight: bold;
            font-size: 1.5rem;
            color: white;
        }
    </style>
</head>
<body>

<!-- Header/Navbar -->
<header>
    <nav class="navbar navbar-expand-md navbar-dark px-3">
        <span class="navbar-brand">User Management App</span>
        <ul class="navbar-nav ms-auto">
            <li class="nav-item">
                <a href="<%=request.getContextPath()%>/list" class="nav-link">Home</a>
            </li>
        </ul>
    </nav>
</header>

<!-- User Form Card -->
<div class="container mt-5">
    <div class="card mx-auto col-md-6">
        <div class="card-header bg-primary text-white">
            <h4 class="text-center mb-0">
                <c:choose>
                    <c:when test="${user != null}">Edit User</c:when>
                    <c:otherwise>Add New User</c:otherwise>
                </c:choose>
            </h4>
        </div>
        <div class="card-body">
            <c:choose>
                <c:when test="${user != null}">
                    <form action="update" method="post">
                        <input type="hidden" name="id" value="${user.id}" />
                </c:when>
                <c:otherwise>
                    <form action="insert" method="post">
                </c:otherwise>
            </c:choose>

                <!-- Name -->
                <div class="mb-3">
                    <label class="form-label">User Name</label>
                    <input type="text" class="form-control" name="name" value="${user.name}" required>
                </div>

                <!-- Email -->
                <div class="mb-3">
                    <label class="form-label">User Email</label>
                    <input type="email" class="form-control" name="email" value="${user.email}">
                </div>

                <!-- Country -->
                <div class="mb-3">
                    <label class="form-label">Country</label>
                    <input type="text" class="form-control" name="country" value="${user.country}">
                </div>

                <!-- Save Button -->
                <div class="text-center">
                    <button type="submit" class="btn btn-success">Save</button>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
