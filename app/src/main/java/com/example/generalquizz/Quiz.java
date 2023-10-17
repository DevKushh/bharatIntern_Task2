package com.example.generalquizz;

public class Quiz {
    public String[] questions = {
            "What is the capital of France ? ",
            "Which planet is known as the 'Red Planet' ? ",
            "What is the capital of Japan ? ",
            "What is the largest mammal in the world ? ",
            "Who is known as the inventor of the light bulb ? ",
            "Which is the longest river in the world ? "
    };

    public String[][] options = {
            {"Berlin", "Madrid", "Paris", "Rome"},
            {"Earth", "Mars", "Venus", "Saturn"},
            {"Beijing","Tokyo","Seoul","Bangkok"},
            {"Elephant","Giraffe","BlueWhale","Polar Bear"},
            {"Thomas Edison","Albert Einstein","Isaac Newton","Galileo Galilei"},
            {" Mississippi River"," Yangtze River","Amazon River","Nile River"}
    };
    public int[] correctAnswers = {2, 1, 1, 2, 0, 3}; // Index of correct answers
}

