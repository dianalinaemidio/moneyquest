package br.senac.sp.moneyquest.quest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class QuestService {

    @Autowired
    private QuestRepository questRepository;

    /**
     * Recupera todas as quests do banco de dados.
     */
    public List<Quest> getAllQuests() {
        return questRepository.findAll();
    }

    /**
     * Recupera uma quest pelo seu ID.
     */
    public Quest getQuestById(Long id) {
        Optional<Quest> questOptional = questRepository.findById(id);
        return questOptional.orElse(null);
    }

    /**
     * Cria uma nova quest no banco de dados.
     */
    public void createQuest(Quest quest) {
        questRepository.save(quest);
    }

    /**
     * Atualiza uma quest existente no banco de dados.
     */
    public void updateQuest(Quest quest) {
        questRepository.save(quest);
    }

    /**
     * Exclui uma quest do banco de dados pelo seu ID.
     */
    public void deleteQuest(Long id) {
        questRepository.deleteById(id);
    }
}

