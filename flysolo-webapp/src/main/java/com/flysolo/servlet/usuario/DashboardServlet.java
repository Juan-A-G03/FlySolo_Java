package com.flysolo.servlet.usuario;

import com.flysolo.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Verificar autenticación
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("usuario") == null) {
            response.sendRedirect(request.getContextPath() + "/jsp/auth/login.jsp");
            return;
        }
        
        // Obtener usuario de la sesión
        User usuario = (User) session.getAttribute("usuario");
        
        // Agregar datos adicionales si es necesario
        request.setAttribute("usuario", usuario);
        
        // Redirigir según tipo de usuario
        String tipoUsuario = usuario.getTipoUsuario().name();
        
        switch (tipoUsuario) {
            case "ADMIN":
                request.getRequestDispatcher("/jsp/admin/dashboard-admin.jsp").forward(request, response);
                break;
            case "PILOTO":
                request.getRequestDispatcher("/jsp/piloto/dashboard-piloto.jsp").forward(request, response);
                break;
            case "PASAJERO":
            default:
                request.getRequestDispatcher("/jsp/user/dashboard.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}