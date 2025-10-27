package ProntoSocorro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.Random;
import java.awt.*;

public class Interface extends javax.swing.JFrame {

    private final Fila fila;
    private final Medico medico;
    private final HistoricoAtendimento historico = new HistoricoAtendimento();

    private JTextField nomeField;
    private JFormattedTextField cpfField;
    private JComboBox<String>[] prioridadeCombo;

    private JTable tabelaFila;
    private JTable tabelaHistorico;

    private JComboBox<String> filtroMedico;
    private JComboBox<String> filtroPrioridade;
    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    
    public Interface(Fila fila, Medico medico) {
        this.fila = fila;
        this.medico = medico;
        historico.setAtendimento(new Atendimento());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 90));
        jLabel1.setText("PRONTO SOCORRO");

        jButton1.setText("Visualizar Fila");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Adicionar Paciente");
        jButton2.setToolTipText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Atender Paciente");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Visualizar Historico");
        jButton4.setToolTipText("");
        jButton4.setActionCommand("jButton2");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                        .addContainerGap())
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(89, 89, 89))
        );

        pack();
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        JPanel panel = new JPanel(new BorderLayout());

        String[] colunas = {"Posição","Nome", "CPF", "Hora de Chegada", "Prioridade"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
        
        int i = 1;
        for (Paciente p : fila.getFila()) {
            Object[] linha = {i, p.getNome(), p.getCpf(), p.getHorarioChegada(), p.getClassificacao()};
            modelo.addRow(linha);
            i++;
        }

        tabelaFila = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabelaFila);
        panel.add(scroll, BorderLayout.CENTER);

        jScrollPane1.setViewportView(panel);
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel filtrosPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        filtroMedico = new JComboBox<>();
        filtroMedico.addItem("Todos");
        for (Medico m : medico.getListMedico()) {
            filtroMedico.addItem(m.getNome());
        }
        filtrosPanel.add(new JLabel("Filtrar Médico:"));
        filtrosPanel.add(filtroMedico);

        filtroPrioridade = new JComboBox<>(new String[]{"Todas", "Vermelho", "Amarelo", "Verde", "Azul"});
        filtrosPanel.add(new JLabel("Filtrar Prioridade:"));
        filtrosPanel.add(filtroPrioridade);

        panel.add(filtrosPanel, BorderLayout.NORTH);

        String[] colunas = {"Nome Paciente","CPF Paciente","Prioridade","Horario de Chegada", "Horário Atendimento","Nome Médico","CRM Médico"};
        DefaultTableModel modelo = new DefaultTableModel(colunas,0);

        Runnable atualizarTabela = () -> {
            modelo.setRowCount(0);
            String medicoSelecionado = (String) filtroMedico.getSelectedItem();
            String prioridadeSelecionada = (String) filtroPrioridade.getSelectedItem();

            for(Atendimento a : historico.getAtendimentosRealizados()){
                Paciente p = a.getPacienteAtendido();
                Medico m = a.getMedico();

                boolean okMedico = medicoSelecionado.equals("Todos") || m.getNome().equals(medicoSelecionado);
                boolean okPrioridade = prioridadeSelecionada.equals("Todas") || p.getClassificacao().equals(prioridadeSelecionada);

                if (okMedico && okPrioridade) {
                    Object[] linha = {p.getNome(), p.getCpf(), p.getClassificacao(), p.getHorarioChegada(), a.getHorarioAtendimento(), m.getNome(), m.getCrm()};
                    modelo.addRow(linha);
                }
            }
        };

        tabelaHistorico = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabelaHistorico);
        panel.add(scroll, BorderLayout.CENTER);

        filtroMedico.addActionListener(e -> atualizarTabela.run());
        filtroPrioridade.addActionListener(e -> atualizarTabela.run());

        atualizarTabela.run();

        jScrollPane1.setViewportView(panel);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Nome:"));
        nomeField = new JTextField(20);
        panel.add(nomeField);

        panel.add(new JLabel("CPF:"));
        try {
            MaskFormatter cpfMask = new MaskFormatter("###.###.###-##");
            cpfMask.setPlaceholderCharacter('_');
            cpfField = new JFormattedTextField(cpfMask);
            panel.add(cpfField);
        } catch (ParseException ex) {
            cpfField = new JFormattedTextField();
            panel.add(cpfField);
        }

        String[] perguntas = {
                "1- Você está com dificuldade para respirar ou sentindo falta de ar?",
                "2- Você está sentindo tontura, desmaio, confusão ou dificuldade para falar?",
                "3- Você sofreu algum trauma, sangramento forte ou tem ferimentos graves?",
                "4- Você sente dor muito forte agora?"
        };
        int[][] valores = {{0,3,6,10},{0,3,6,9},{0,2,5,8},{0,1,3,5}};
        int[] pontuacao = new int[4];

        prioridadeCombo = new JComboBox[4];

        for(int i=0;i<4;i++){
            panel.add(new JLabel(perguntas[i]));
            JComboBox<String> combo = new JComboBox<>(new String[]{"Nada","Leve","Moderado","Muito"});
            int idx = i;
            combo.addActionListener(ev -> pontuacao[idx] = valores[idx][combo.getSelectedIndex()]);
            prioridadeCombo[i] = combo;
            panel.add(combo);
        }

        JButton confirmar = new JButton("Confirmar");
        confirmar.addActionListener(ev -> {
            int soma = pontuacao[0]+pontuacao[1]+pontuacao[2]+pontuacao[3];
            Paciente novo = new Paciente(nomeField.getText(), cpfField.getText(),
                    java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss")));
            novo.setClassificacao(soma);
            fila.adicionarFila(novo);
            JOptionPane.showMessageDialog(this,"Paciente adicionado: "+novo.getNome());
            nomeField.setText("");
            cpfField.setText("");
            for(JComboBox<String> c : prioridadeCombo) c.setSelectedIndex(0);
        });

        panel.add(confirmar);

        jScrollPane1.setViewportView(panel);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        if(fila.getFila().isEmpty()){
            JOptionPane.showMessageDialog(this,"Não há pacientes na fila!");
            return;
        }

        Random r = new Random();
        Medico m = medico.getMedico(r.nextInt(3));
        Paciente p = fila.removeFila();

        Atendimento a = new Atendimento();
        a.setFila(fila);
        a.realizaAtendimento(p, m);

        historico.addAtendimentoRealizado(a);

        JOptionPane.showMessageDialog(this,"Paciente " + p.getNome() + " atendido!");

        if(tabelaFila != null){
            jButton1ActionPerformed(null);
        }
        if(tabelaHistorico != null){
            jButton4ActionPerformed(null);
        }
    }

    public static void main(String args[]) {
        Fila fila = new Fila();
        Medico medico = new Medico();
        medico.iniciaMedico();
        fila.iniciaFila();
        java.awt.EventQueue.invokeLater(() -> new Interface(fila, medico).setVisible(true));
    }
    
}
