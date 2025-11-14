<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - FlySolo</title>
    <link rel="stylesheet" href="../../css/style.css">
</head>
<body>
    <div class="container">
        <header class="header">
            <h1>🚀 FlySolo</h1>
            <p>Iniciar Sesión</p>
        </header>
        
        <div class="form-container">
            <h2 style="text-align: center; color: #2a5298; margin-bottom: 30px;">Bienvenido de Vuelta</h2>
            
            <!-- Mostrar errores si existen -->
            <% if (request.getAttribute("errorMessage") != null) { %>
                <div class="error-message">
                    <%= request.getAttribute("errorMessage") %>
                </div>
            <% } %>
            
            <!-- Mostrar mensaje de éxito si existe (como registro exitoso) -->
            <% if (request.getAttribute("successMessage") != null) { %>
                <div class="success-message">
                    <%= request.getAttribute("successMessage") %>
                </div>
            <% } %>
            
            <!-- Mostrar mensaje si viene del registro -->
            <% if (request.getParameter("registered") != null) { %>
                <div class="success-message">
                    ¡Cuenta creada exitosamente! Ahora puedes iniciar sesión.
                </div>
            <% } %>
            
            <form action="../../login" method="post" id="loginForm">
                <!-- Email -->
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" required 
                           value="<%= request.getAttribute("email") != null ? request.getAttribute("email") : "" %>"
                           placeholder="tu@email.com">
                </div>
                
                <!-- Password -->
                <div class="form-group">
                    <label for="password">Contraseña</label>
                    <input type="password" id="password" name="password" required 
                           placeholder="Tu contraseña">
                </div>
                
                <!-- Recordarme -->
                <div class="form-group">
                    <label style="display: flex; align-items: center; gap: 10px;">
                        <input type="checkbox" id="recordarme" name="recordarme" style="width: auto;">
                        Recordarme en este dispositivo
                    </label>
                </div>
                
                <!-- Botones -->
                <div class="form-group">
                    <button type="submit" class="btn btn-primary" style="width: 100%; margin-bottom: 15px;">
                        Iniciar Sesión
                    </button>
                    <div style="text-align: center;">
                        <a href="register.jsp" style="color: #2a5298; text-decoration: none; margin-right: 20px;">
                            ¿No tienes cuenta? Regístrate
                        </a>
                        <a href="#" style="color: #666; text-decoration: none;">
                            ¿Olvidaste tu contraseña?
                        </a>
                    </div>
                </div>
            </form>
            
            <!-- Demo users -->
            <div style="background: #f8f9fa; padding: 20px; border-radius: 8px; margin-top: 30px;">
                <h4 style="color: #2a5298; margin-bottom: 15px;">👥 Usuarios de Prueba:</h4>
                <div style="font-size: 0.9em; color: #666;">
                    <p><strong>Admin:</strong> admin@flysolo.com / admin123</p>
                    <p><strong>Piloto:</strong> luke@rebeldes.com / luke1234</p>
                    <p><strong>Pasajero:</strong> leia@rebeldes.com / leia1234</p>
                </div>
            </div>
        </div>
        
        <footer class="footer">
            <p>&copy; 2025 FlySolo - Sistema de Transporte Espacial</p>
        </footer>
    </div>
    
    <script>
        // Auto-fill demo user para testing rápido
        function fillDemo(email, password) {
            document.getElementById('email').value = email;
            document.getElementById('password').value = password;
        }
        
        // Validación básica
        document.getElementById('loginForm').addEventListener('submit', function(e) {
            const email = document.getElementById('email').value.trim();
            const password = document.getElementById('password').value.trim();
            
            if (!email || !password) {
                e.preventDefault();
                alert('Por favor completa todos los campos');
                return false;
            }
        });
    </script>
</body>
</html>