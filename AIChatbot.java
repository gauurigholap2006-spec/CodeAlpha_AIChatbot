import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AIChatbot {

    // Store FAQs and predefined responses
    private static final Map<String, String> faqMap = new HashMap<>();

    static {
        faqMap.put("what is java", "Java is a popular object-oriented programming language used for web, mobile, and enterprise apps.");
        faqMap.put("what is codealpha", "CodeAlpha is a software development company offering real-world internship opportunities.");
        faqMap.put("who created you", "I was created by a Java developer as part of the CodeAlpha Internship Program!");
        faqMap.put("what can you do", "I can answer your FAQs, tell you the current time/date, and have basic conversations.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("       AI CHATBOT ASSISTANT         ");
        System.out.println("====================================");
        System.out.println("Bot: Hello! I am your AI Chatbot. Type 'bye' or 'exit' to end the chat.\n");

        while (true) {
            System.out.print("You: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.isEmpty()) {
                continue;
            }

            // Exit Condition
            if (input.equals("bye") || input.equals("exit") || input.equals("quit")) {
                System.out.println("Bot: Goodbye! Have a great day ahead! 👋");
                break;
            }

            // Process user message and get response
            String response = getBotResponse(input);
            System.out.println("Bot: " + response + "\n");
        }

        scanner.close();
    }

    private static String getBotResponse(String input) {
        // Greetings
        if (input.contains("hello") || input.contains("hi") || input.contains("hey")) {
            return "Hello there! How can I assist you today?";
        }

        // How are you
        if (input.contains("how are you")) {
            return "I'm doing great, thank you! How about you?";
        }

        // Date and Time Intent
        if (input.contains("time") || input.contains("date")) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            return "Current Date & Time is: " + dtf.format(now);
        }

        // Help Intent
        if (input.contains("help")) {
            return "You can ask me questions like 'What is Java?', 'What is CodeAlpha?', 'What time is it?', or just say 'Hello'!";
        }

        // Check in FAQ database
        for (String question : faqMap.keySet()) {
            if (input.contains(question)) {
                return faqMap.get(question);
            }
        }

        // Default Fallback Response
        return "I'm sorry, I didn't quite understand that. Type 'help' to see what I can answer!";
    }
}