package IstTeam5;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerForm extends JFrame implements ActionListener {
    private CustomersDatabase customersDb;
    private JLabel welcomeLabel;
    private JLabel titleLabel, firstNameLabel, lastNameLabel, emailLabel, phoneLabel, stateLabel;
    private JTextField firstNameField, lastNameField, emailField, phoneField;
    private JComboBox<String> stateComboBox;
    private JCheckBox termsCheckBox;
    private JButton submitButton;

    public CustomerForm() {
        super("Bike Store");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 650);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 1, 10, 10)); // Use a single column layout
        getContentPane().setBackground(new Color(240, 234, 214));

        // Initialize the CustomersDatabase instance
        customersDb = new CustomersDatabase();

        welcomeLabel = new JLabel("Welcome to the Bike Shop");
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(welcomeLabel);

        JPanel firstNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Use FlowLayout with left alignment
        firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField();
        firstNameField.setPreferredSize(new Dimension(200, 30));
        firstNamePanel.add(firstNameLabel);
        firstNamePanel.add(firstNameField);
        add(firstNamePanel);

        JPanel lastNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Use FlowLayout with left alignment
        lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField();
        lastNameField.setPreferredSize(new Dimension(200, 30));
        lastNamePanel.add(lastNameLabel);
        lastNamePanel.add(lastNameField);
        add(lastNamePanel);

        JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Use FlowLayout with left alignment
        emailLabel = new JLabel("E-mail:");
        emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(200, 30));
        emailPanel.add(emailLabel);
        emailPanel.add(emailField);
        add(emailPanel);

        JPanel phonePanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Use FlowLayout with left alignment
        phoneLabel = new JLabel("Phone:");
        phoneField = new JTextField();
        phoneField.setPreferredSize(new Dimension(200, 30));
        phonePanel.add(phoneLabel);
        phonePanel.add(phoneField);
        add(phonePanel);

        // Add the stateComboBox to a panel
        JPanel statePanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Use FlowLayout with left alignment
        stateLabel = new JLabel("State:");
        String[] states = new String[]{"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"};


        stateComboBox = new JComboBox<>(states);
        statePanel.add(stateLabel);
        statePanel.add(stateComboBox);
        add(statePanel);

        termsCheckBox = new JCheckBox("Accept the Terms and Conditions");
        add(termsCheckBox);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this); // Register this as the action listener for the submitButton
        add(submitButton);

        setVisible(true);
    }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == submitButton) { // If the submitButton was clicked
                // Get the customer information from the text fields and the combo box
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String email = emailField.getText();
                String phone = phoneField.getText();
                String state = stateComboBox.getSelectedItem().toString();

                // Validate that the required fields are filled out
                if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please fill out all required fields", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validate that the terms and conditions checkbox is checked
                if (!termsCheckBox.isSelected()) {
                    JOptionPane.showMessageDialog(this, "Please accept the terms and conditions", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Create a new Customer object with the entered information
                Customer customer = new Customer( firstName, lastName, email, phone);

                // Add the customer to the database using the CustomersDatabase instance
                boolean success = customersDb.saveCustomer(customer);
                if (success) {
                    JOptionPane.showMessageDialog(this, "Customer added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    // Clear the text fields
                    firstNameField.setText("");
                    lastNameField.setText("");
                    emailField.setText("");
                    phoneField.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Error adding customer", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        public static void main(String[] args) {
            new CustomerForm();
        }

        public JButton getsubmitButton() {
            return submitButton ;
        }
    }