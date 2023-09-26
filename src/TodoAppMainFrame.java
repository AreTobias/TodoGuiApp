import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TodoAppMainFrame extends JFrame {
    private JButton createTodo;
    private JButton showTodo;
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JButton Show;
    private JButton Create;
    private JButton Delete;
    private JPanel exitButtonPanel;
    private JButton exitButton;
    private JButton Exit;

    public TodoAppMainFrame(){
        setTitle("Todo app");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        add(buttonPanel, BorderLayout.CENTER);
        add(exitButtonPanel, BorderLayout.SOUTH);
        setVisible(true);

        Create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                CreateTodoWindow createTodo = new CreateTodoWindow();
                createTodo.setVisible(true);
                System.out.println("Hello from Create button");
            }
        });

        Show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {


                TodoAppShowTodos showTodos = new TodoAppShowTodos();
                showTodos.setVisible(true);
                setVisible(false);
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });
    }
}
