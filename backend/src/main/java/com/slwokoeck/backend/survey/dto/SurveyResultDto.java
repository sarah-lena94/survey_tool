package com.slwokoeck.backend.survey.dto;

public class SurveyResultDto {
    private String questionText;
    private Double averageAnswer;

    public SurveyResultDto() {
    }

    public SurveyResultDto(String questionText, Double averageAnswer) {
        this.questionText = questionText;
        this.averageAnswer = averageAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Double getAverageAnswer() {
        return averageAnswer;
    }

    public void setAverageAnswer(Double averageAnswer) {
        this.averageAnswer = averageAnswer;
    }
}