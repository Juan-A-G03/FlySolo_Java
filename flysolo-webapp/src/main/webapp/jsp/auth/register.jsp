<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro - FlySolo</title>
    <link rel="stylesheet" href="../../css/style.css">
</head>
<body>
    <div class="container">
        <header class="header">
            <h1>🚀 FlySolo</h1>
            <p>Registro de Nueva Cuenta</p>
        </header>
        
        <div class="form-container">
            <h2 style="text-align: center; color: #2a5298; margin-bottom: 30px;">Crear Cuenta</h2>
            
            <!-- Mostrar errores si existen -->
            <% if (request.getAttribute("errorMessage") != null) { %>
                <div class="error-message">
                    <%= request.getAttribute("errorMessage") %>
                </div>
            <% } %>
            
            <!-- Mostrar mensaje de éxito si existe -->
            <% if (request.getAttribute("successMessage") != null) { %>
                <div class="success-message">
                    <%= request.getAttribute("successMessage") %>
                </div>
            <% } %>
            
            <form action="../../register" method="post" id="registerForm">
                <!-- Email -->
                <div class="form-group">
                    <label for="email">Email *</label>
                    <input type="email" id="email" name="email" required 
                           value="<%= request.getAttribute("email") != null ? request.getAttribute("email") : "" %>"
                           placeholder="tu@email.com">
                </div>
                
                <!-- Password -->
                <div class="form-group">
                    <label for="password">Contraseña *</label>
                    <input type="password" id="password" name="password" required 
                           placeholder="Mínimo 8 caracteres, letras y números">
                    <small style="color: #666; font-size: 0.9em;">
                        Debe contener al menos 8 caracteres, una letra y un número
                    </small>
                </div>
                
                <!-- Confirm Password -->
                <div class="form-group">
                    <label for="confirmPassword">Confirmar Contraseña *</label>
                    <input type="password" id="confirmPassword" name="confirmPassword" required 
                           placeholder="Repite tu contraseña">
                </div>
                
                <!-- Nombre -->
                <div class="form-group">
                    <label for="nombre">Nombre *</label>
                    <input type="text" id="nombre" name="nombre" required 
                           value="<%= request.getAttribute("nombre") != null ? request.getAttribute("nombre") : "" %>"
                           placeholder="Tu nombre">
                </div>
                
                <!-- Apellido -->
                <div class="form-group">
                    <label for="apellido">Apellido *</label>
                    <input type="text" id="apellido" name="apellido" required 
                           value="<%= request.getAttribute("apellido") != null ? request.getAttribute("apellido") : "" %>"
                           placeholder="Tu apellido">
                </div>
                
                <!-- Facción -->
                <div class="form-group">
                    <label for="faccionId">Facción *</label>
                    <select id="faccionId" name="faccionId" required>
                        <option value="">Selecciona tu facción</option>
                        <option value="1" <%= "1".equals(String.valueOf(request.getAttribute("faccionId"))) ? "selected" : "" %>>
                            🏛️ Imperio Galáctico
                        </option>
                        <option value="2" <%= "2".equals(String.valueOf(request.getAttribute("faccionId"))) ? "selected" : "" %>>
                            ⭐ Alianza Rebelde
                        </option>
                        <option value="3" <%= "3".equals(String.valueOf(request.getAttribute("faccionId"))) ? "selected" : "" %>>
                            ⚖️ Neutral
                        </option>
                    </select>
                </div>
                
                <!-- Términos y condiciones -->
                <div class="form-group">
                    <label style="display: flex; align-items: center; gap: 10px;">
                        <input type="checkbox" id="terms" required style="width: auto;">
                        Acepto los términos y condiciones de FlySolo
                    </label>
                </div>
                
                <!-- Botones -->
                <div class="form-group">
                    <button type="submit" class="btn btn-primary" style="width: 100%; margin-bottom: 15px;">
                        Crear Cuenta
                    </button>
                    <div style="text-align: center;">
                        <a href="login.jsp" style="color: #2a5298; text-decoration: none;">
                            ¿Ya tienes cuenta? Inicia sesión
                        </a>
                    </div>
                </div>
            </form>
        </div>
        
        <footer class="footer">
            <p>&copy; 2025 FlySolo - Sistema de Transporte Espacial</p>
        </footer>
    </div>
    
    <script>
        // Validación básica del formulario
        document.getElementById('registerForm').addEventListener('submit', function(e) {
            const password = document.getElementById('password').value;
            const confirmPassword = document.getElementById('confirmPassword').value;
            
            if (password !== confirmPassword) {
                e.preventDefault();
                alert('Las contraseñas no coinciden');
                return false;
            }
            
            if (password.length < 8) {
                e.preventDefault();
                alert('La contraseña debe tener al menos 8 caracteres');
                return false;
            }
            
            const hasLetter = /[a-zA-Z]/.test(password);
            const hasNumber = /[0-9]/.test(password);
            
            if (!hasLetter || !hasNumber) {
                e.preventDefault();
                alert('La contraseña debe contener al menos una letra y un número');
                return false;
            }
        });
    </script>
</body>
</html>