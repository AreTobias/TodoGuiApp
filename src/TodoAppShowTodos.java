import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import static javax.swing.JOptionPane.showMessageDialog;

public class TodoAppShowTodos extends JFrame {
    private JPanel mainPanel;
    private JPanel TodoInfoPanel;
    private JTextArea TodosArea;
    private DefaultListModel model = new DefaultListModel();

    private JButton completeTodo;
    private JPanel buttonPanel;
    private JButton backButton;
    private JLabel todoLabel;

    public TodoAppShowTodos() {
        setTitle("Show todo's");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        add(mainPanel);
        add(buttonPanel, BorderLayout.SOUTH);

        JList TodoList = new JList(model);
        model.addAll(CreateTodoWindow.getTodos());
        TodoInfoPanel.add(TodoList);
        add(TodoInfoPanel, BorderLayout.NORTH);
        System.out.println("Info table added?");

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                setVisible(false);
                TodoAppMainFrame mainApp = new TodoAppMainFrame();
                mainApp.setVisible(true);
            }
        });
        completeTodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                  showMessageDialog(null,TodoList.getSelectedValue() + "\nhas been marked as completed and removed!");
                  CreateTodoWindow.removeCompletedTodo(TodoList.getSelectedValue().toString());
                  model.remove(TodoList.getSelectedIndex());

            }
        });
    }


}
