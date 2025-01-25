/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Test;

/**
 *
 * @author marwa
 */
public sealed class TestResult permits Pass, Fail {
    private final String message;

    public TestResult(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    
}


