package br.senac.sp.moneyquest.quest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

import java.util.List;


@Controller
@RequestMapping("/quest")
public class QuestController {

    @Autowired
    private QuestService questService;

    /**
     * Exibe o formulário para criar uma nova quest.
     */
    @GetMapping("/new")
    public String form(Quest quest) {
        return "quest/new";
    }

    /**
     * Salva uma nova quest no banco de dados.
     */
    @PostMapping("/quest")
    public String saveQuest(@Valid Quest quest, BindingResult result ) {
        questService.createQuest(quest);
        return "redirect:/quest";
    }
    
    /**
     * Exibe o formulário para editar uma quest existente.
     */
    @GetMapping("/quest/{id}/edit")
    public String editQuest(@PathVariable Long id, Model model) {
        Quest quest = questService.getQuestById(id);
        model.addAttribute("quest", quest);
        return "quest/edit";
    }


    /**
     * Atualiza uma quest existente no banco de dados.
     */
    @PostMapping("/{id}/update")
    public String updateQuest(@PathVariable Long id, Quest quest, RedirectAttributes redirectAttributes) {
        quest.setId(id);
        questService.updateQuest(quest);
        redirectAttributes.addFlashAttribute("successMessage", "Quest updated successfully.");
        return "redirect:/quest";
    }

    /**
     * Exclui uma quest do banco de dados.
     */
    @GetMapping("/delete/{id}")
    public String deleteQuest(@PathVariable Long id) {
        questService.deleteQuest(id);   
        return "redirect:/quest";
    }

    /**
     * Exibe a lista de todas as quests.
     */
    @GetMapping
    public String index(Model model) {
        List<Quest> quests = questService.getAllQuests();
        model.addAttribute("quests", quests);
        return "quest/index";
    }
}

