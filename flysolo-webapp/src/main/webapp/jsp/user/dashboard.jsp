<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.flysolo.model.User" %>
<%
    // Verificar que el usuario esté logueado
    User usuario = (User) session.getAttribute("usuario");
    if (usuario == null) {
        response.sendRedirect("../auth/login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - FlySolo</title>
    <link rel="stylesheet" href="../../css/style.css">
</head>
<body>
    <div class="container">
        <header class="header">
            <h1>🚀 FlySolo</h1>
            <p>Panel de Control</p>
        </header>
        
        <div class="main-content">
            <!-- Bienvenida personalizada -->
            <div class="welcome-section">
                <h2>¡Bienvenido, <%= usuario.getNombre() %> <%= usuario.getApellido() %>!</h2>
                <p>Tipo de usuario: <strong><%= usuario.getTipoUsuario().getDisplayName() %></strong></p>
                <p>Email: <%= usuario.getEmail() %></p>
                <p>Facción: 
                    <% 
                    String faccionNombre = "";
                    String faccionColor = "";
                    switch(usuario.getFaccionId()) {
                        case 1: faccionNombre = "Imperio Galáctico"; faccionColor = "#DC143C"; break;
                        case 2: faccionNombre = "Alianza Rebelde"; faccionColor = "#4169E1"; break;
                        case 3: faccionNombre = "Neutral"; faccionColor = "#708090"; break;
                    }
                    %>
                    <span style="color: <%= faccionColor %>; font-weight: bold;">
                        <%= faccionNombre %>
                    </span>
                </p>
            </div>
            
            <!-- Opciones según tipo de usuario -->
            <div class="features">
                <% if ("PASAJERO".equals(usuario.getTipoUsuario().name())) { %>
                    <div class="feature">
                        <h3>✈️ Solicitar Viaje</h3>
                        <p>Encuentra un piloto para tu próximo destino</p>
                        <a href="#" class="btn btn-primary">Crear Viaje</a>
                    </div>
                    <div class="feature">
                        <h3>📋 Mis Viajes</h3>
                        <p>Ver historial y viajes pendientes</p>
                        <a href="#" class="btn btn-secondary">Ver Viajes</a>
                    </div>
                    <div class="feature">
                        <h3>🚁 Ser Piloto</h3>
                        <p>Solicita convertirte en piloto</p>
                        <a href="#" class="btn btn-secondary">Solicitar</a>
                    </div>
                <% } else if ("PILOTO".equals(usuario.getTipoUsuario().name())) { %>
                    <div class="feature">
                        <h3>🎯 Viajes Disponibles</h3>
                        <p>Encuentra pasajeros que necesiten transporte</p>
                        <a href="#" class="btn btn-primary">Ver Disponibles</a>
                    </div>
                    <div class="feature">
                        <h3>🚀 Mi Nave</h3>
                        <p>Gestionar mi nave y estado</p>
                        <a href="#" class="btn btn-secondary">Gestionar</a>
                    </div>
                    <div class="feature">
                        <h3>📊 Mis Estadísticas</h3>
                        <p>Rating, viajes completados y reseñas</p>
                        <a href="#" class="btn btn-secondary">Ver Stats</a>
                    </div>
                <% } else if ("ADMIN".equals(usuario.getTipoUsuario().name())) { %>
                    <div class="feature">
                        <h3>👥 Gestionar Usuarios</h3>
                        <p>Administrar usuarios del sistema</p>
                        <a href="#" class="btn btn-primary">Gestionar</a>
                    </div>
                    <div class="feature">
                        <h3>✅ Aprobar Pilotos</h3>
                        <p>Revisar solicitudes de piloto</p>
                        <a href="#" class="btn btn-primary">Aprobar</a>
                    </div>
                    <div class="feature">
                        <h3>📈 Reportes</h3>
                        <p>Estadísticas del sistema</p>
                        <a href="#" class="btn btn-secondary">Ver Reportes</a>
                    </div>
                <% } %>
            </div>
            
            <!-- Botón de logout -->
            <div style="text-align: center; margin-top: 40px;">
                <a href="../../logout" class="btn btn-secondary">Cerrar Sesión</a>
            </div>
        </div>
        
        <footer class="footer">
            <p>&copy; 2025 FlySolo - Sistema de Transporte Espacial</p>
        </footer>
    </div>
</body>
</html>