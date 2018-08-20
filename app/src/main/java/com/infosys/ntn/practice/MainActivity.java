package com.infosys.ntn.practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.infosys.ntn.practice.Common.Common;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button0;
    private Button buttonPoint;
    private Button buttonEqual;
    private Button buttonDelete;
    private Button buttonAdd;
    private Button buttonSubtract;
    private Button buttonMultiple;
    private Button buttonDivide;
    TextView calculateTextView;
    TextView answerTextView;


    private static final String CLEAR = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize instances
        initControl();
        // Initialize Listener
        initListener();
    }



    private void onNumberButton(String pushedButton) {
        String formula;
        formula = calculateTextView.getText().toString();
        formula = formula + pushedButton;
        calculateTextView.setText(formula);

        // Will proceed calculation. if there is answer, answer will be displayed to answer screen
        if (formula.contains(Common.CAL_ADD) ||
                formula.contains(Common.CAL_SUBTRACT) ||
                formula.contains(Common.CAL_MULTIPLE) ||
                formula.contains(Common.CAL_DIVIDE)) {
            String answer = calculateAnswer(formula);
            answerTextView.setText(answer);
        }
    }

        private void onSymbolButton (String pushedButton){
            String formula;
            formula = calculateTextView.getText().toString();
            if (formula.isEmpty()) {
                return;
            }
            String firstLetter = String.valueOf(formula.charAt(formula.length() - 1));
            if (Common.CAL_ADD.equals(firstLetter) ||
                    Common.CAL_SUBTRACT.equals(firstLetter) ||
                    Common.CAL_MULTIPLE.equals(firstLetter) ||
                    Common.CAL_DIVIDE.equals(firstLetter) ||
                    Common.POINT.equals(firstLetter)) {
                return;
            } else {
                formula = formula + pushedButton;
                calculateTextView.setText(formula);
            }
        }

    /**
     * Input formula to args. And if formula is crated properly, answer will be responded
     *
     * @param formula
     * @return If there is answer, answer will be responded. If not, empty value will be responded
     */
    private String calculateAnswer(String formula) {
        Expression e = new ExpressionBuilder(formula).build();
        try {
            double result = e.evaluate();
            return Double.toString(result);

        } catch (IllegalArgumentException illegalArgumentException) {
            return "";
        }
    }

        private void onDeleteButton () {
            calculateTextView.setText(CLEAR);
            answerTextView.setText(CLEAR);
        }


        private void initListener () {
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onNumberButton(Common.NUMBER_1);
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onNumberButton(Common.NUMBER_2);
                }
            });
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onNumberButton(Common.NUMBER_3);
                }
            });
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onNumberButton(Common.NUMBER_4);
                }
            });
            button5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onNumberButton(Common.NUMBER_5);
                }
            });
            button6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onNumberButton(Common.NUMBER_6);
                }
            });
            button7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onNumberButton(Common.NUMBER_7);
                }
            });
            button8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onNumberButton(Common.NUMBER_8);
                }
            });
            button9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onNumberButton(Common.NUMBER_9);
                }
            });
            button0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onNumberButton(Common.NUMBER_0);
                }
            });

            buttonPoint.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onNumberButton(".");
                }
            });
            buttonAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onSymbolButton(Common.CAL_ADD);
                }
            });
            buttonSubtract.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onSymbolButton(Common.CAL_SUBTRACT);
                }
            });
            buttonMultiple.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onSymbolButton(Common.CAL_MULTIPLE);
                }
            });
            buttonDivide.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onSymbolButton(Common.CAL_DIVIDE);
                }
            });

            buttonDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onDeleteButton();
                }
            });

        }


        private void initControl () {
            button1 = findViewById(R.id.button_1);
            button2 = findViewById(R.id.button_2);
            button3 = findViewById(R.id.button_3);
            button4 = findViewById(R.id.button_4);
            button5 = findViewById(R.id.button_5);
            button6 = findViewById(R.id.button_6);
            button7 = findViewById(R.id.button_7);
            button8 = findViewById(R.id.button_8);
            button9 = findViewById(R.id.button_9);
            button0 = findViewById(R.id.button_0);
            buttonPoint = findViewById(R.id.button_point);
            buttonEqual = findViewById(R.id.button_equal);
            buttonAdd = findViewById(R.id.button_Plus);
            buttonSubtract = findViewById(R.id.button_Minus);
            buttonMultiple = findViewById(R.id.button_multiple);
            buttonDivide = findViewById(R.id.button_devide);
            buttonDelete = findViewById(R.id.button_delete);
            calculateTextView = findViewById(R.id.calculate);
            answerTextView = findViewById(R.id.answer);
        }


    }

