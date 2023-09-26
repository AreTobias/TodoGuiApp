import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import static javax.swing.JOptionPane.showMessageDialog;

public class CreateTodoWindow extends JFrame{
    private JPanel mainPanel;
    private JPanel InfoPanel;
    private JLabel todoName;
    private JTextField todoNameField;
    private JButton Confirm;
    private JButton Cancel;
    private JPanel createButtonPanel;
    private static ArrayList<String> Todos = new ArrayList<>();



    public CreateTodoWindow() {
        setTitle("Create Todo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        add(InfoPanel, BorderLayout.NORTH);
        add(createButtonPanel, BorderLayout.SOUTH);

        //Todos.add("Henge opp tøy");
        //Todos.add("Ta ut av oppvaskmaskinen");
        //Todos.add("Støvsuge");
        Confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if (validateTodo()){
                    showMessageDialog(null, "This todo already exists!");
                    todoNameField.setText("");
                } else {
                    Todos.add(todoNameField.getText());
                    todoNameField.setText("");
                }
            }
        });
        Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                setVisible(false);


            }
        });
    }



    // This method is used in the Show todo logic
    // Which means this method has to make a check to make sure
    // it doesnt add the same todos every time a new todo is created
    // -- That is currently a bug. --
    public static ArrayList<String> getTodos() {
        Set<String> todos = new HashSet<>();

        todos.addAll(Todos);
        ArrayList<String> uniqueTodos = new ArrayList<>(new TreeSet<>(todos));
        return uniqueTodos;
    }

    public static void removeCompletedTodo(String todo) {
        Todos.remove(todo);
    }


    /**
     * This method is to validate that we're not adding the same todo twice.
     * The ArrayList `Todos` is what we have to check against.
     *
     * This method returns true if the todo exists, false if it doesnt.
     *
     * **/
    public  boolean validateTodo() {
        String todo = todoNameField.getText();
        boolean validate = false;
        for (int i = 0; i <= Todos.size() - 1; i++){
            validate = Todos.get(i).equalsIgnoreCase(todo);
        }
        return validate;
    }



}
