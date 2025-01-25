/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Test;

import java.util.List;

/**
 *
 * @author marwa
 */
public final class Fail extends TestResult {
    private final String retryMessage;
   // private final List<TestQuestion> failedQuestions;


    public Fail(String message, String retryMessage) {
        super(message);  
        this.retryMessage = retryMessage;
       // this.failedQuestions = failedQuestions;

    }

    public String getRetryMessage() {
        return retryMessage;
    }
    
   /* public List<TestQuestion> getFailedQuestions() {
        return failedQuestions;
    }*/
}
