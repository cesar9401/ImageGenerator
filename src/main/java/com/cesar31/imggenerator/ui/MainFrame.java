package com.cesar31.imggenerator.ui;

import com.cesar31.imggenerator.control.MainController;
import com.cesar31.imggenerator.model.User;
import com.cesar31.imggenerator.structures.ListNode;
import com.cesar31.imggenerator.structures.ObjectList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author cesar31
 */
public class MainFrame extends javax.swing.JFrame {

    private MainController controller;
    private User user;

    public MainFrame() {
        initComponents();
        controller = new MainController(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        tabbedPane = new javax.swing.JTabbedPane();
        userPane = new javax.swing.JPanel();
        addLabel = new javax.swing.JLabel();
        addText = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        searchLabel = new javax.swing.JLabel();
        editText = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        delButton = new javax.swing.JButton();
        userLabel = new javax.swing.JLabel();
        editButton = new javax.swing.JButton();
        imgPane = new javax.swing.JPanel();
        layersText = new javax.swing.JTextField();
        titleLabel = new javax.swing.JLabel();
        recorridoLabel = new javax.swing.JLabel();
        generateButton = new javax.swing.JButton();
        typeCombo = new javax.swing.JComboBox<>();
        idLabel = new javax.swing.JLabel();
        idText = new javax.swing.JTextField();
        genIdButton = new javax.swing.JButton();
        layerLabel = new javax.swing.JLabel();
        layerText = new javax.swing.JTextField();
        genLayButton = new javax.swing.JButton();
        usrLabel = new javax.swing.JLabel();
        usrText = new javax.swing.JTextField();
        imgCombo = new javax.swing.JComboBox<>();
        usrImgButton = new javax.swing.JButton();
        searchUsrButton = new javax.swing.JButton();
        memoryPane = new javax.swing.JPanel();
        genRepButton = new javax.swing.JButton();
        reportCombo = new javax.swing.JComboBox<>();
        statusLabel = new javax.swing.JLabel();
        layerIdText = new javax.swing.JTextField();
        genLayerButton = new javax.swing.JButton();
        layerLabel1 = new javax.swing.JLabel();
        layerLabel2 = new javax.swing.JLabel();
        imgText = new javax.swing.JTextField();
        genGrafButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        capasItem = new javax.swing.JMenuItem();
        imgItem = new javax.swing.JMenuItem();
        usuariosItem = new javax.swing.JMenuItem();
        exitItem = new javax.swing.JMenuItem();
        fileMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estructura de Datos");
        setBackground(new java.awt.Color(40, 44, 52));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1200, 800));
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(40, 44, 52));
        mainPanel.setForeground(new java.awt.Color(255, 255, 255));
        mainPanel.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        tabbedPane.setBackground(new java.awt.Color(40, 44, 52));
        tabbedPane.setForeground(new java.awt.Color(255, 255, 255));
        tabbedPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tabbedPane.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N

        userPane.setBackground(new java.awt.Color(40, 44, 52));
        userPane.setForeground(new java.awt.Color(255, 255, 255));

        addLabel.setBackground(new java.awt.Color(40, 44, 52));
        addLabel.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        addLabel.setForeground(new java.awt.Color(255, 255, 255));
        addLabel.setText("Agregar Usuario");

        addText.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        addText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTextActionPerformed(evt);
            }
        });

        addButton.setBackground(new java.awt.Color(220, 118, 51));
        addButton.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        addButton.setForeground(new java.awt.Color(0, 0, 0));
        addButton.setText("Agregar");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        searchLabel.setBackground(new java.awt.Color(40, 44, 52));
        searchLabel.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        searchLabel.setForeground(new java.awt.Color(255, 255, 255));
        searchLabel.setText("Buscar Usuario");

        editText.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        editText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTextActionPerformed(evt);
            }
        });

        searchButton.setBackground(new java.awt.Color(220, 118, 51));
        searchButton.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        searchButton.setForeground(new java.awt.Color(0, 0, 0));
        searchButton.setText("Buscar");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        delButton.setBackground(new java.awt.Color(220, 118, 51));
        delButton.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        delButton.setForeground(new java.awt.Color(0, 0, 0));
        delButton.setText("Eliminar");
        delButton.setEnabled(false);
        delButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delButtonActionPerformed(evt);
            }
        });

        userLabel.setBackground(new java.awt.Color(40, 44, 52));
        userLabel.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        userLabel.setForeground(new java.awt.Color(255, 255, 255));
        userLabel.setText("Usuario:");

        editButton.setBackground(new java.awt.Color(220, 118, 51));
        editButton.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        editButton.setForeground(new java.awt.Color(0, 0, 0));
        editButton.setText("Editar");
        editButton.setEnabled(false);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout userPaneLayout = new javax.swing.GroupLayout(userPane);
        userPane.setLayout(userPaneLayout);
        userPaneLayout.setHorizontalGroup(
            userPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPaneLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(userPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addLabel)
                    .addGroup(userPaneLayout.createSequentialGroup()
                        .addComponent(addText, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(userPaneLayout.createSequentialGroup()
                        .addComponent(delButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(searchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(userPaneLayout.createSequentialGroup()
                        .addGroup(userPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(userLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(editText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(410, Short.MAX_VALUE))
        );
        userPaneLayout.setVerticalGroup(
            userPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPaneLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(addLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(userPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addText, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(81, 81, 81)
                .addComponent(searchLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(userPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editText, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(userLabel)
                .addGap(18, 18, 18)
                .addGroup(userPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delButton, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(290, 290, 290))
        );

        tabbedPane.addTab("Usuarios", userPane);

        imgPane.setBackground(new java.awt.Color(40, 44, 52));
        imgPane.setForeground(new java.awt.Color(255, 255, 255));

        layersText.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        layersText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                layersTextActionPerformed(evt);
            }
        });

        titleLabel.setBackground(new java.awt.Color(40, 44, 52));
        titleLabel.setFont(new java.awt.Font("Roboto", 0, 48)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("Generar Imagen");

        recorridoLabel.setBackground(new java.awt.Color(40, 44, 52));
        recorridoLabel.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        recorridoLabel.setForeground(new java.awt.Color(255, 255, 255));
        recorridoLabel.setText("Por recorrido limitado");

        generateButton.setBackground(new java.awt.Color(220, 118, 51));
        generateButton.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        generateButton.setForeground(new java.awt.Color(0, 0, 0));
        generateButton.setText("Generar");
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });

        typeCombo.setBackground(new java.awt.Color(220, 118, 51));
        typeCombo.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        typeCombo.setForeground(new java.awt.Color(255, 255, 255));
        typeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "InOrden", "PreOrden", "PostOrden" }));

        idLabel.setBackground(new java.awt.Color(40, 44, 52));
        idLabel.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        idLabel.setForeground(new java.awt.Color(255, 255, 255));
        idLabel.setText("Buscar por id");

        idText.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        idText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTextActionPerformed(evt);
            }
        });

        genIdButton.setBackground(new java.awt.Color(220, 118, 51));
        genIdButton.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        genIdButton.setForeground(new java.awt.Color(0, 0, 0));
        genIdButton.setText("Generar");
        genIdButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genIdButtonActionPerformed(evt);
            }
        });

        layerLabel.setBackground(new java.awt.Color(40, 44, 52));
        layerLabel.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        layerLabel.setForeground(new java.awt.Color(255, 255, 255));
        layerLabel.setText("Buscar capa");

        layerText.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        layerText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                layerTextActionPerformed(evt);
            }
        });

        genLayButton.setBackground(new java.awt.Color(220, 118, 51));
        genLayButton.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        genLayButton.setForeground(new java.awt.Color(0, 0, 0));
        genLayButton.setText("Generar");
        genLayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genLayButtonActionPerformed(evt);
            }
        });

        usrLabel.setBackground(new java.awt.Color(40, 44, 52));
        usrLabel.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        usrLabel.setForeground(new java.awt.Color(255, 255, 255));
        usrLabel.setText("Buscar por Usuario");

        usrText.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        usrText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usrTextActionPerformed(evt);
            }
        });

        imgCombo.setBackground(new java.awt.Color(220, 118, 51));
        imgCombo.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        imgCombo.setForeground(new java.awt.Color(255, 255, 255));

        usrImgButton.setBackground(new java.awt.Color(220, 118, 51));
        usrImgButton.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        usrImgButton.setForeground(new java.awt.Color(0, 0, 0));
        usrImgButton.setText("Generar");
        usrImgButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usrImgButtonActionPerformed(evt);
            }
        });

        searchUsrButton.setBackground(new java.awt.Color(220, 118, 51));
        searchUsrButton.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        searchUsrButton.setForeground(new java.awt.Color(0, 0, 0));
        searchUsrButton.setText("Buscar Usuario");
        searchUsrButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchUsrButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout imgPaneLayout = new javax.swing.GroupLayout(imgPane);
        imgPane.setLayout(imgPaneLayout);
        imgPaneLayout.setHorizontalGroup(
            imgPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imgPaneLayout.createSequentialGroup()
                .addGroup(imgPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(imgPaneLayout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(imgPaneLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(imgPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(layersText, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(recorridoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(layerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(layerText, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usrLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usrText, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(imgPaneLayout.createSequentialGroup()
                                .addComponent(imgCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(usrImgButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addGroup(imgPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(genIdButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(genLayButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchUsrButton, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                            .addComponent(typeCombo, 0, 215, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addComponent(generateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(201, Short.MAX_VALUE))
        );
        imgPaneLayout.setVerticalGroup(
            imgPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imgPaneLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(recorridoLabel)
                .addGroup(imgPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(imgPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(typeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(generateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(imgPaneLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(layersText, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62)
                .addComponent(idLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(imgPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(genIdButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(idText, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(49, 49, 49)
                .addComponent(layerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(imgPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(layerText, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genLayButton, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(usrLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(imgPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usrText, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchUsrButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(imgPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imgCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usrImgButton, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Imagenes", imgPane);

        memoryPane.setBackground(new java.awt.Color(40, 44, 52));
        memoryPane.setForeground(new java.awt.Color(255, 255, 255));

        genRepButton.setBackground(new java.awt.Color(220, 118, 51));
        genRepButton.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        genRepButton.setForeground(new java.awt.Color(0, 0, 0));
        genRepButton.setText("Generar Reporte");
        genRepButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genRepButtonActionPerformed(evt);
            }
        });

        reportCombo.setBackground(new java.awt.Color(220, 118, 51));
        reportCombo.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        reportCombo.setForeground(new java.awt.Color(255, 255, 255));
        reportCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Listado de Imagenes", "Arbol de Capas", "Arbol de Usuarios" }));

        statusLabel.setBackground(new java.awt.Color(40, 44, 52));
        statusLabel.setFont(new java.awt.Font("Roboto", 0, 48)); // NOI18N
        statusLabel.setForeground(new java.awt.Color(255, 255, 255));
        statusLabel.setText("Estado de Memoria");

        layerIdText.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        layerIdText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                layerIdTextActionPerformed(evt);
            }
        });

        genLayerButton.setBackground(new java.awt.Color(220, 118, 51));
        genLayerButton.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        genLayerButton.setForeground(new java.awt.Color(0, 0, 0));
        genLayerButton.setText("Generar Capa");
        genLayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genLayerButtonActionPerformed(evt);
            }
        });

        layerLabel1.setBackground(new java.awt.Color(40, 44, 52));
        layerLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        layerLabel1.setForeground(new java.awt.Color(255, 255, 255));
        layerLabel1.setText("Buscar capa");

        layerLabel2.setBackground(new java.awt.Color(40, 44, 52));
        layerLabel2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        layerLabel2.setForeground(new java.awt.Color(255, 255, 255));
        layerLabel2.setText("Imagen y arbol de capas");

        imgText.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        imgText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imgTextActionPerformed(evt);
            }
        });

        genGrafButton.setBackground(new java.awt.Color(220, 118, 51));
        genGrafButton.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        genGrafButton.setForeground(new java.awt.Color(0, 0, 0));
        genGrafButton.setText("Generar grafico");
        genGrafButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genGrafButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout memoryPaneLayout = new javax.swing.GroupLayout(memoryPane);
        memoryPane.setLayout(memoryPaneLayout);
        memoryPaneLayout.setHorizontalGroup(
            memoryPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(memoryPaneLayout.createSequentialGroup()
                .addGroup(memoryPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(memoryPaneLayout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(memoryPaneLayout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addGroup(memoryPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(layerLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(layerLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(memoryPaneLayout.createSequentialGroup()
                                .addGroup(memoryPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(imgText, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(layerIdText, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(reportCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, 400, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(memoryPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(genRepButton, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(genLayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(genGrafButton, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(257, Short.MAX_VALUE))
        );
        memoryPaneLayout.setVerticalGroup(
            memoryPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(memoryPaneLayout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(statusLabel)
                .addGap(94, 94, 94)
                .addGroup(memoryPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reportCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genRepButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(layerLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(memoryPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(layerIdText, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genLayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(layerLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(memoryPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imgText, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genGrafButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(194, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Memoria", memoryPane);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        menuBar.setBackground(new java.awt.Color(40, 44, 52));
        menuBar.setForeground(new java.awt.Color(255, 255, 255));
        menuBar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        fileMenu.setBackground(new java.awt.Color(40, 44, 52));
        fileMenu.setForeground(new java.awt.Color(255, 255, 255));
        fileMenu.setText("Archivos");
        fileMenu.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N

        capasItem.setBackground(new java.awt.Color(40, 44, 52));
        capasItem.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        capasItem.setForeground(new java.awt.Color(255, 255, 255));
        capasItem.setText("Cargar Capas...");
        capasItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capasItemActionPerformed(evt);
            }
        });
        fileMenu.add(capasItem);

        imgItem.setBackground(new java.awt.Color(40, 44, 52));
        imgItem.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        imgItem.setForeground(new java.awt.Color(255, 255, 255));
        imgItem.setText("Cargar Imagenes...");
        imgItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imgItemActionPerformed(evt);
            }
        });
        fileMenu.add(imgItem);

        usuariosItem.setBackground(new java.awt.Color(40, 44, 52));
        usuariosItem.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        usuariosItem.setForeground(new java.awt.Color(255, 255, 255));
        usuariosItem.setText("Cargar Usuarios...");
        usuariosItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuariosItemActionPerformed(evt);
            }
        });
        fileMenu.add(usuariosItem);

        exitItem.setBackground(new java.awt.Color(40, 44, 52));
        exitItem.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        exitItem.setForeground(new java.awt.Color(255, 255, 255));
        exitItem.setText("Salir");
        exitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);

        fileMenu1.setBackground(new java.awt.Color(40, 44, 52));
        fileMenu1.setForeground(new java.awt.Color(255, 255, 255));
        fileMenu1.setText("Aplicacion");
        fileMenu1.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        menuBar.add(fileMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void capasItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capasItemActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("capas *.cap", "cap"));
        int sel = fc.showOpenDialog(this);
        if (sel == JFileChooser.APPROVE_OPTION) {
            String path = fc.getSelectedFile().getAbsolutePath();
            boolean read = this.controller.readLayers(path);
            if (read) {
                showMessage("Capas cargadas con exito", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            } else {
                showMessage("Error al cargar capas", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_capasItemActionPerformed

    private void imgItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imgItemActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("imagenes *.im", "im"));
        int sel = fc.showOpenDialog(this);
        if (sel == JFileChooser.APPROVE_OPTION) {
            String path = fc.getSelectedFile().getAbsolutePath();
            boolean read = this.controller.readImages(path);
            if (read) {
                showMessage("Imagenes cargadas con exito", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            } else {
                showMessage("Error al cargar Imagenes", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_imgItemActionPerformed

    private void usuariosItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariosItemActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("usuarios *.usr", "usr"));
        int sel = fc.showOpenDialog(this);
        if (sel == JFileChooser.APPROVE_OPTION) {
            String path = fc.getSelectedFile().getAbsolutePath();
            boolean read = this.controller.readUsers(path);
            if (read) {
                showMessage("Usuarios cargados con exito", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            } else {
                showMessage("Error al cargar usuarios", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_usuariosItemActionPerformed

    private void exitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitItemActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_exitItemActionPerformed

    private void addTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addTextActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        String input = addText.getText();
        controller.addUser(input);
        disableButtons();
    }//GEN-LAST:event_addButtonActionPerformed

    private void editTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editTextActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        String input = editText.getText();
        this.user = controller.getUser(input);
        if (user != null) {
            userLabel.setText("Usuario: " + user.getId());
            delButton.setEnabled(true);
            editButton.setEnabled(true);
        } else {
            showMessage("No se encontro al usuario: " + input, "Error", JOptionPane.ERROR_MESSAGE);
            disableButtons();
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void delButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delButtonActionPerformed
        // TODO add your handling code here:
        if (this.user != null) {
            int res = JOptionPane.showConfirmDialog(this, "Desea eliminar al usuario: " + user.getId(), "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (res == JOptionPane.YES_OPTION) {
                this.controller.delUser(this.user.getId());
                this.user = null;
                disableButtons();
            }
        }
    }//GEN-LAST:event_delButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        if (this.user != null) {
            String id = editText.getText();
            this.controller.editUser(id, user);
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void layersTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_layersTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_layersTextActionPerformed

    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateButtonActionPerformed
        // TODO add your handling code here:
        String input = layersText.getText();
        String type = typeCombo.getSelectedItem().toString();

        System.out.println("type = " + type);
        controller.generateImgByTour(input, type);
    }//GEN-LAST:event_generateButtonActionPerformed

    private void idTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTextActionPerformed

    private void genIdButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genIdButtonActionPerformed
        // TODO add your handling code here:
        String id = idText.getText();
        controller.generateImgById(id);
    }//GEN-LAST:event_genIdButtonActionPerformed

    private void layerTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_layerTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_layerTextActionPerformed

    private void genLayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genLayButtonActionPerformed
        // TODO add your handling code here:
        String layerId = layerText.getText();
        controller.generateImgByLayer(layerId);
    }//GEN-LAST:event_genLayButtonActionPerformed

    private void usrTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usrTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usrTextActionPerformed

    private void usrImgButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usrImgButtonActionPerformed
        // TODO add your handling code here:
        if(imgCombo.getItemCount() > 0) {
            String id = String.valueOf(imgCombo.getSelectedItem());
            controller.generateImgById(id);
        }
    }//GEN-LAST:event_usrImgButtonActionPerformed

    private void searchUsrButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchUsrButtonActionPerformed
        // TODO add your handling code here:
        imgCombo.removeAll();

        String id = usrText.getText();
        User usr = controller.getUser(id);
        if (usr != null) {
            ObjectList imgs = usr.getImages();
            ListNode aux = imgs.getRoot();
            while (aux != null) {
                imgCombo.addItem(String.valueOf(aux.getId()));
                aux = aux.getNext();
            }
        }
    }//GEN-LAST:event_searchUsrButtonActionPerformed

    private void genRepButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genRepButtonActionPerformed
        // TODO add your handling code here:
        String type = String.valueOf(reportCombo.getSelectedItem());
        controller.memoryStatus(type);
    }//GEN-LAST:event_genRepButtonActionPerformed

    private void layerIdTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_layerIdTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_layerIdTextActionPerformed

    private void genLayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genLayerButtonActionPerformed
        // TODO add your handling code here:
        String layerId = layerIdText.getText();
        controller.generateLayer(layerId);
    }//GEN-LAST:event_genLayerButtonActionPerformed

    private void imgTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imgTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imgTextActionPerformed

    private void genGrafButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genGrafButtonActionPerformed
        // TODO add your handling code here:
        String imgId = imgText.getText();
        controller.generateImgWithAVL(imgId);
    }//GEN-LAST:event_genGrafButtonActionPerformed

    public void showMessage(String message, String title, int type) {
        JOptionPane.showMessageDialog(this, message, title, type);
    }

    public void disableButtons() {
        editText.setText("");
        userLabel.setText("Usuario:");
        delButton.setEnabled(false);
        editButton.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel addLabel;
    public javax.swing.JTextField addText;
    private javax.swing.JMenuItem capasItem;
    private javax.swing.JButton delButton;
    private javax.swing.JButton editButton;
    public javax.swing.JTextField editText;
    private javax.swing.JMenuItem exitItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu fileMenu1;
    private javax.swing.JButton genGrafButton;
    private javax.swing.JButton genIdButton;
    private javax.swing.JButton genLayButton;
    private javax.swing.JButton genLayerButton;
    private javax.swing.JButton genRepButton;
    private javax.swing.JButton generateButton;
    private javax.swing.JLabel idLabel;
    public javax.swing.JTextField idText;
    private javax.swing.JComboBox<String> imgCombo;
    private javax.swing.JMenuItem imgItem;
    private javax.swing.JPanel imgPane;
    public javax.swing.JTextField imgText;
    public javax.swing.JTextField layerIdText;
    private javax.swing.JLabel layerLabel;
    private javax.swing.JLabel layerLabel1;
    private javax.swing.JLabel layerLabel2;
    public javax.swing.JTextField layerText;
    public javax.swing.JTextField layersText;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel memoryPane;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JLabel recorridoLabel;
    private javax.swing.JComboBox<String> reportCombo;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JButton searchUsrButton;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JComboBox<String> typeCombo;
    private javax.swing.JLabel userLabel;
    private javax.swing.JPanel userPane;
    private javax.swing.JButton usrImgButton;
    private javax.swing.JLabel usrLabel;
    public javax.swing.JTextField usrText;
    private javax.swing.JMenuItem usuariosItem;
    // End of variables declaration//GEN-END:variables
}
