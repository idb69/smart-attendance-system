package com.onlineexam.system.controller;

import com.onlineexam.system.entity.Question;
import com.onlineexam.system.repository.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "*")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;


    // ==============================
    // GET ALL QUESTIONS
    // ==============================
    @GetMapping
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }


    // ==============================
    // ADD NEW QUESTION
    // ==============================
    @PostMapping
    public Question addQuestion(@RequestBody Question question) {
        return questionRepository.save(question);
    }


    // ==============================
    // GET QUESTION BY ID
    // ==============================
    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable Long id) {

        return questionRepository
                .findById(id)
                .orElse(null);
    }


 // ==============================
 // UPDATE QUESTION
 // ==============================

 @PutMapping("/{id}")
 public Question updateQuestion(
         @PathVariable Long id,
         @RequestBody Question updatedQuestion) {

     return questionRepository.findById(id)
             .map(question -> {

                 question.setQuestionText(
                         updatedQuestion.getQuestionText()
                 );

                 question.setOptiona(
                         updatedQuestion.getOptiona()
                 );

                 question.setOptionb(
                         updatedQuestion.getOptionb()
                 );

                 question.setOptionc(
                         updatedQuestion.getOptionc()
                 );

                 question.setOptiond(
                         updatedQuestion.getOptiond()
                 );

                 question.setCorrectAnswer(
                         updatedQuestion.getCorrectAnswer()
                 );

                 return questionRepository.save(question);

             })
             .orElse(null);
     }
    // ==============================
    // DELETE QUESTION
    // ==============================
    @DeleteMapping("/{id}")
    public String deleteQuestion(@PathVariable Long id) {

        questionRepository.deleteById(id);

        return "Question deleted successfully";
    }
}