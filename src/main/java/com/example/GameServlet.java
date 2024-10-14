package com.example;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
    private GameLogic gameLogic;

    @Override
    public void init() throws ServletException {
        super.init();
        gameLogic = new GameLogic();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String choice = request.getParameter("choice");

        // Retrieve the current game state from the session
        String gameState = (String) session.getAttribute("gameState");

        // Use GameLogic class to process the choice and get the updated game state
        gameState = gameLogic.processChoice(gameState, choice);

        // Set the updated game state in the session
        session.setAttribute("gameState", gameState);

        // Forward the request to index.jsp
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}