package com.onlineexam.system.controller;

import com.onlineexam.system.entity.Question;
import com.onlineexam.system.entity.Result;

import com.onlineexam.system.repository.QuestionRepository;
import com.onlineexam.system.repository.ResultRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class ExamController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ResultRepository resultRepository;


    // =========================================
    // HOME PAGE
    // =========================================

    @GetMapping("/")
    public String home() {

        return "index";

    }


    // =========================================
    // EXAM PAGE
    // =========================================

    @GetMapping("/exam")
    public String showExam(

            @RequestParam String studentName,
            Model model

    ) {

        List<Question> questions =
                questionRepository.findAll();

        model.addAttribute(
                "questions",
                questions
        );

        model.addAttribute(
                "studentName",
                studentName
        );

        return "exam";

    }


    // =========================================
    // ADMIN PAGE
    // =========================================

    @GetMapping("/admin")
    public String showAdmin(Model model) {

        List<Question> questions =
                questionRepository.findAll();

        model.addAttribute(
                "questions",
                questions
        );

        return "admin";

    }


    // =========================================
    // ADMIN RESULTS PAGE
    // =========================================

    @GetMapping("/admin/results")
    public String showResults(Model model) {

        List<Result> results = resultRepository.findAll();

        System.out.println("================================");
        System.out.println("TOTAL RESULTS = " + results.size());
        System.out.println("RESULTS = " + results);
        System.out.println("================================");

        model.addAttribute("results", results);

        return "admin-results";
    }


    // =========================================
    // SUBMIT EXAM
    // =========================================

    @PostMapping("/submit-exam")
    public String submitExam(

            @RequestParam Map<String, String> answers,

            @RequestParam String studentName,

            Model model

    ) {

        List<Question> questions =
                questionRepository.findAll();

        int score = 0;

        List<Map<String, Object>> answerDetails =
                new ArrayList<>();


        // CHECK ANSWERS

        for (Question question : questions) {

            String key =
                    "question_" + question.getId();

            String studentAnswer =
                    answers.get(key);

            String correctAnswer =
                    question.getCorrectAnswer();


            boolean isCorrect =
                    studentAnswer != null &&
                    studentAnswer.equalsIgnoreCase(correctAnswer);


            if (isCorrect) {
                score++;
            }


            Map<String, Object> detail =
                    new HashMap<>();


            detail.put(
                    "question",
                    question
            );


            detail.put(
                    "studentAnswer",
                    studentAnswer != null
                            ? studentAnswer
                            : "Not Answered"
            );


            detail.put(
                    "correctAnswer",
                    correctAnswer
            );


            detail.put(
                    "isCorrect",
                    isCorrect
            );


            answerDetails.add(detail);
        }


        // CALCULATE PERCENTAGE

        double percentage = 0;

        if (!questions.isEmpty()) {

            percentage =
                    ((double) score /
                            questions.size()) * 100;
        }


        // PASS / FAIL

        String resultStatus;

        if (percentage >= 40) {

            resultStatus = "PASS";

        } else {

            resultStatus = "FAIL";
        }


        // SAVE RESULT DATABASE

        Result examResult =
                new Result();

        examResult.setStudentName(studentName);

        examResult.setScore(score);

        examResult.setTotalQuestions(
                questions.size()
        );

        examResult.setPercentage(percentage);

        examResult.setResultStatus(resultStatus);


        resultRepository.save(examResult);


        // SEND DATA TO results.html

        model.addAttribute(
                "studentName",
                studentName
        );

        model.addAttribute(
                "score",
                score
        );

        model.addAttribute(
                "totalQuestions",
                questions.size()
        );

        model.addAttribute(
                "percentage",
                percentage
        );

        model.addAttribute(
                "resultStatus",
                resultStatus
        );

        model.addAttribute(
                "answerDetails",
                answerDetails
        );


        // IMPORTANT

        return "results";
    }
}