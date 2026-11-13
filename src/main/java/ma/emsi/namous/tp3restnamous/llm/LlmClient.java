package ma.emsi.namous.tp3restnamous.llm;

import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.enterprise.context.Dependent;

import java.io.Serializable;

@Dependent
public class LlmClient implements Serializable {

    private GuideTouristique guideTouristique;
    private ChatMemory chatMemory;

    public LlmClient() {

        ChatModel model = GoogleGenAiChatModel.builder()
                .apiKey(System.getenv("GEMINI_KEY"))
                .modelName("gemini-3.5-flash-lite")
                .temperature(0.3)
                .build();

        this.chatMemory = MessageWindowChatMemory.withMaxMessages(20);
        this.chatMemory = MessageWindowChatMemory.withMaxMessages(20);
        this.chatMemory.add(new SystemMessage("""
                Tu es un guide touristique. Pour la ville ou le pays indiqué, donne les  endroits à visiter selon le nombre indiqué pas plus ni moins et aussi le prix moyen d'un repas dans la devise du pays.
                Réponds qu'avec JSON selon ce format
                {
                    "ville_ou_pays": "nom de la ville ou du pays",
                    "endroits_a_visiter": ["endroit 1", "endroit 2" (selon le nombre indiqué)],
                    "prix_moyen_repas": "<prix> <devise du pays>"
                }
                """));

        this.guideTouristique = AiServices.builder(GuideTouristique.class)
                .chatModel(model)
                .chatMemory(chatMemory)
                .build();
    }

    public String conversation(String lieu) {
        return this.guideTouristique.conversation(lieu);
    }
}