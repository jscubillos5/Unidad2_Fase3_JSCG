/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import BusinessLogic.UsuarioDatosBasicos;
import JPA.Persona;
import JPA.Rol;
import JPA.TipoIdentificacion;
import JPA.TipoPersona;
import JPA.Usuario;
import Util.GeneralException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.util.List;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author Juan Cubillos
 */
public class User extends javax.swing.JFrame {

    class UppercaseDocumentFilter extends DocumentFilter {

        @Override
        public void insertString(DocumentFilter.FilterBypass fb, int offset,
                String text, AttributeSet attr) throws BadLocationException {
            fb.insertString(offset, text.toUpperCase(), attr);
        }

        @Override
        public void replace(DocumentFilter.FilterBypass fb, int offset, int length,
                String text, AttributeSet attrs) throws BadLocationException {
            fb.replace(offset, length, text.toUpperCase(), attrs);
        }
    }

    /**
     * Creates new form User
     *
     * @throws java.text.ParseException
     */
    public User() throws ParseException {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        DocumentFilter filter = new User.UppercaseDocumentFilter();
        ((AbstractDocument) jTextFieldUsuario.getDocument()).setDocumentFilter(filter);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.Unidad2_Fase3_JSCG_Unidad2_Fase3_JSCG_jar_1.0PU");
        EntityManager em = entityManagerFactory.createEntityManager();
        Query queryTipoIdentificacion = em.createNamedQuery("TipoIdentificacion.findAll");
        jComboBoxTipoDocumento.removeAllItems();
        List<TipoIdentificacion> listTipoIdentificacion = queryTipoIdentificacion.getResultList();
        listTipoIdentificacion.forEach((TipoIdentificacion tipoIdentificacion) -> {
            jComboBoxTipoDocumento.addItem(tipoIdentificacion.getDescripcion());
        });
        Query queryRol = em.createNamedQuery("Rol.findAll");
        jComboBoxRol.removeAllItems();
        List<Rol> listRol = queryRol.getResultList();
        listRol.forEach((rol) -> {
            jComboBoxRol.addItem(rol.getDescripcion());
        });
        LoadjComboBoxUsuarioAndjTableUsuarios();
    }

    private void LoadjComboBoxUsuarioAndjTableUsuarios() throws ParseException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.Unidad2_Fase3_JSCG_Unidad2_Fase3_JSCG_jar_1.0PU");
        EntityManager em = entityManagerFactory.createEntityManager();
        Query queryUsuario = em.createNamedQuery("Usuario.findAll");
        jComboBoxUsuario.removeAllItems();
        List<Usuario> listUsuario = queryUsuario.getResultList();
        listUsuario.forEach((Usuario usuario) -> {
            jComboBoxUsuario.addItem(usuario.getUsuario());
        });
        // Implementacion concepto herencia: Uso concepto, JSCG, UNAD, 20190703
        List<Object[]> results = em.createNativeQuery("select persona.id_persona, persona.nombre, persona.apellido, persona.edad, persona.fecha_nacimiento, persona.identificacion, usuario.id_usuario, usuario.usuario, usuario.bloqueado from unidad_2_fase_3_301403_2_jscg.usuario inner join unidad_2_fase_3_301403_2_jscg.persona on (unidad_2_fase_3_301403_2_jscg.usuario.id_persona = unidad_2_fase_3_301403_2_jscg.persona.id_persona) order by 1").getResultList();
        List<UsuarioDatosBasicos> listUsuarioDatosBasicos = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        for (Object[] result : results) {
            Date fechaNacimiento = df.parse(result[4].toString());
            UsuarioDatosBasicos usuarioDatosBasicos = new UsuarioDatosBasicos(Integer.parseInt(result[0].toString()), result[1].toString(), result[2].toString(), Integer.parseInt(result[3].toString()), fechaNacimiento, result[5].toString(), Integer.parseInt(result[6].toString()), result[7].toString(), Boolean.parseBoolean(result[8].toString()));
            listUsuarioDatosBasicos.add(usuarioDatosBasicos);
        }
        DefaultTableModel model = new DefaultTableModel(null, new Object[]{"ID PERSONA", "NOMBRE", "APELLIDO", "EDAD", "FECHA NACIMIENTO", "IDENTIFICACION", "ID USUARIO", "USUARIO", "ESTADO BLOQUEADO"});
        listUsuarioDatosBasicos.forEach((usuarioDatosBasicos) -> {
            model.addRow(new Object[]{usuarioDatosBasicos.getIdPersona(), usuarioDatosBasicos.getNombre(), usuarioDatosBasicos.getApellido(), usuarioDatosBasicos.getEdad(), usuarioDatosBasicos.getFechaNacimiento(), usuarioDatosBasicos.getIdentificacion(), usuarioDatosBasicos.getIdUsuario(), usuarioDatosBasicos.getUsuario(), usuarioDatosBasicos.getBloqueado()});
        });
        jTableUsuarios.setModel(model);
        em.close();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabelAyuda = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabelApellido = new javax.swing.JLabel();
        jTextFieldApellido = new javax.swing.JTextField();
        jLabelEdad = new javax.swing.JLabel();
        jTextFieldEdad = new javax.swing.JTextField();
        jLabelFechaNacimiento = new javax.swing.JLabel();
        jLabelNumeroDocumento = new javax.swing.JLabel();
        jTextFieldNumeroDocumento = new javax.swing.JTextField();
        jLabelTipoDocumento = new javax.swing.JLabel();
        jComboBoxTipoDocumento = new javax.swing.JComboBox<>();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jLabelClave = new javax.swing.JLabel();
        jTextFieldClave = new javax.swing.JTextField();
        jLabelRol = new javax.swing.JLabel();
        jComboBoxRol = new javax.swing.JComboBox<>();
        jButtonRegistrarUsuario = new javax.swing.JButton();
        jDateChooserFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxUsuario = new javax.swing.JComboBox<>();
        jButtonEliminarUsuario = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableUsuarios = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administración de usuarios");

        jLabelAyuda.setText("Bienvenido señor usuario, usted podra administrar sus usuarios en esta pantalla.");

        jLabelNombre.setText("Nombre");

        jLabelApellido.setText("Apellido");

        jLabelEdad.setText("Edad");

        jTextFieldEdad.setText("0");
        jTextFieldEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldEdadKeyPressed(evt);
            }
        });

        jLabelFechaNacimiento.setText("Fecha nacimiento");

        jLabelNumeroDocumento.setText("Número documento");

        jLabelTipoDocumento.setText("Tipo documento");

        jComboBoxTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelUsuario.setText("Usuario");

        jLabelClave.setText("Contraseña");

        jLabelRol.setText("Rol");

        jComboBoxRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonRegistrarUsuario.setText("Registrar");
        jButtonRegistrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarUsuarioActionPerformed(evt);
            }
        });

        jLabel1.setText("Usuario");

        jComboBoxUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonEliminarUsuario.setText("Eliminar");
        jButtonEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarUsuarioActionPerformed(evt);
            }
        });

        jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableUsuarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelAyuda)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelNombre)
                                            .addComponent(jLabelApellido)
                                            .addComponent(jLabelEdad)
                                            .addComponent(jLabelRol)
                                            .addComponent(jLabelUsuario))
                                        .addGap(93, 93, 93)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButtonRegistrarUsuario)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jComboBoxRol, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jTextFieldNombre)
                                                        .addComponent(jTextFieldApellido)
                                                        .addComponent(jTextFieldEdad, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
                                                    .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(25, 25, 25)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabelClave)
                                                    .addComponent(jLabelNumeroDocumento)
                                                    .addComponent(jLabelTipoDocumento)
                                                    .addComponent(jLabelFechaNacimiento))))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextFieldNumeroDocumento)
                                            .addComponent(jComboBoxTipoDocumento, 0, 236, Short.MAX_VALUE)
                                            .addComponent(jTextFieldClave)
                                            .addComponent(jDateChooserFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(105, 105, 105)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonEliminarUsuario)
                                    .addComponent(jComboBoxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 22, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelEdad)
                        .addComponent(jTextFieldEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooserFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelAyuda)
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelNombre)
                                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelNumeroDocumento)
                                    .addComponent(jTextFieldNumeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelApellido)
                                    .addComponent(jTextFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelTipoDocumento)
                                    .addComponent(jComboBoxTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabelFechaNacimiento)))
                        .addGap(6, 6, 6)))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsuario)
                    .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelClave)
                    .addComponent(jTextFieldClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRol))
                .addGap(28, 28, 28)
                .addComponent(jButtonRegistrarUsuario)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonEliminarUsuario)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegistrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarUsuarioActionPerformed
        // TODO add your handling code here:
        ValidateFormRegisterUser();
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.Unidad2_Fase3_JSCG_Unidad2_Fase3_JSCG_jar_1.0PU");
            EntityManager em = entityManagerFactory.createEntityManager();
            int countUser = ((Number) em.createNamedQuery("Usuario.findByUsuarioCount").setParameter("usuario", jTextFieldUsuario.getText()).getSingleResult()).intValue();
            if (countUser > 0) {
                jTextFieldUsuario.setText("");
                JOptionPane.showMessageDialog(null, "El nombre del usuario ya fue registrado", "Error", JOptionPane.ERROR_MESSAGE);
                throw new GeneralException("El nombre del usuario ya fue registrado");
            }
            em.close();
        } catch (GeneralException | HeadlessException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.Unidad2_Fase3_JSCG_Unidad2_Fase3_JSCG_jar_1.0PU");
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();
        try {
            entityTransaction.begin();
            Persona persona = new Persona();
            persona.setNombre(jTextFieldNombre.getText());
            persona.setApellido(jTextFieldApellido.getText());
            persona.setEdad(Integer.parseInt(jTextFieldEdad.getText()));
            persona.setFechaNacimiento(jDateChooserFechaNacimiento.getDate());
            final int TIPO_EMPLEADO = 1;
            TipoPersona tipoPersona = new TipoPersona();
            tipoPersona.setIdTipoPersona(TIPO_EMPLEADO);
            persona.setIdTipoPersona(tipoPersona);
            TipoIdentificacion tipoIdentificacion = new TipoIdentificacion();
            tipoIdentificacion.setIdTipoIdentificacion(jComboBoxTipoDocumento.getSelectedIndex() + 1);
            persona.setIdTipoIdentificacion(tipoIdentificacion);
            persona.setIdentificacion(jTextFieldNumeroDocumento.getText());
            em.persist(persona);
            Usuario usuario = new Usuario();
            usuario.setUsuario(jTextFieldUsuario.getText());
            usuario.setClave(jTextFieldClave.getText());
            usuario.setBloqueado(false);
            usuario.setIdPersona(persona);
            Rol rol = new Rol(jComboBoxRol.getSelectedIndex() + 1);
            usuario.setIdRol(rol);
            em.persist(usuario);
            entityTransaction.commit();
            em.close();
            JOptionPane.showMessageDialog(null, "El usuario: " + usuario.getUsuario() + ", con nombre: " + persona.getNombre() + ", fue registrado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            CleanFormRegisterUser();
            LoadjComboBoxUsuarioAndjTableUsuarios();
        } catch (HeadlessException | NumberFormatException ex) {
            entityTransaction.rollback();
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Atención ocurrio un error al guardar el usuario, error especifico: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonRegistrarUsuarioActionPerformed

    private void jTextFieldEdadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEdadKeyPressed
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if ((key >= evt.VK_0 && key <= evt.VK_9) || (key >= evt.VK_NUMPAD0 && key <= evt.VK_NUMPAD9) || key == KeyEvent.VK_BACK_SPACE) {
            jTextFieldEdad.setEditable(true);
            jTextFieldEdad.setBackground(Color.GREEN);
        } else {
            jTextFieldEdad.setEditable(false);
            jTextFieldEdad.setBackground(Color.RED);
        }
    }//GEN-LAST:event_jTextFieldEdadKeyPressed

    private void jButtonEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarUsuarioActionPerformed
        ValidateFormDeleteUser();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.Unidad2_Fase3_JSCG_Unidad2_Fase3_JSCG_jar_1.0PU");
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();
        try {
            entityTransaction.begin(); 
            Usuario usuario = (Usuario) em.createNamedQuery("Usuario.findByUsuario").setParameter("usuario", jComboBoxUsuario.getSelectedItem().toString()).getSingleResult();           
            em.remove(usuario);
            entityTransaction.commit();
            em.close();
            JOptionPane.showMessageDialog(null, "El usuario: " + usuario.getUsuario() + ", fue eliminado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            CleanFormDeleteUser();
            LoadjComboBoxUsuarioAndjTableUsuarios();
        } catch (HeadlessException | NumberFormatException ex) {
            entityTransaction.rollback();
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Atención ocurrio un error al eliminar el usuario, error especifico: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonEliminarUsuarioActionPerformed

    private void ValidateFormDeleteUser() {
        try {
            if (jComboBoxUsuario.getSelectedIndex() < 0) {
                JOptionPane.showMessageDialog(null, "El usuario es obligatorio, para eliminar un usuario", "Error", JOptionPane.ERROR_MESSAGE);
                throw new GeneralException("El usuario es obligatorio, para eliminar un usuario");
            }
        } catch (GeneralException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ValidateFormRegisterUser() {
        try {
            if (jTextFieldNombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El nombre de la persona es obligatorio, para registrarse como usuario", "Error", JOptionPane.ERROR_MESSAGE);
                throw new GeneralException("El nombre de la persona es obligatorio, para registrarse como usuario");
            }
            if (jTextFieldApellido.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El apellido de la persona es obligatorio, para registrarse como usuario", "Error", JOptionPane.ERROR_MESSAGE);
                throw new GeneralException("El apellido de la persona es obligatorio, para registrarse como usuario");
            }
            if (jTextFieldNumeroDocumento.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El número de documento de la persona es obligatorio, para registrarse como usuario", "Error", JOptionPane.ERROR_MESSAGE);
                throw new GeneralException("El número de documento de la persona es obligatorio, para registrarse como usuario");
            }
            if (jComboBoxTipoDocumento.getSelectedIndex() < 0) {
                JOptionPane.showMessageDialog(null, "El tipo de documento es obligatorio, para registrarse como usuario", "Error", JOptionPane.ERROR_MESSAGE);
                throw new GeneralException("El tipo de documento es obligatorio, para registrarse como usuario");
            }
            if (jTextFieldEdad.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "La edad de la persona es obligatoria, para registrarse como usuario", "Error", JOptionPane.ERROR_MESSAGE);
                throw new GeneralException("La edad de la persona es obligatoria, para registrarse como usuario");
            }
            if (jDateChooserFechaNacimiento.getDate() == null) {
                JOptionPane.showMessageDialog(null, "La fecha de nacimiento es obligatoria, para registrarse como usuario", "Error", JOptionPane.ERROR_MESSAGE);
                throw new GeneralException("La fecha de nacimiento es obligatoria, para registrarse como usuario");
            }
            if (jTextFieldUsuario.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El usuario es obligatorio, para registrarse como usuario", "Error", JOptionPane.ERROR_MESSAGE);
                throw new GeneralException("El usuario es obligatorio, para registrarse como usuario");
            }
            if (jTextFieldClave.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "La clave del usuario es obligatoria, para registrarse como usuario", "Error", JOptionPane.ERROR_MESSAGE);
                throw new GeneralException("La clave del usuario es obligatoria, para registrarse como usuario");
            }
            if (jComboBoxRol.getSelectedIndex() < 0) {
                JOptionPane.showMessageDialog(null, "El rol del usuario obligatorio, para registrarse como usuario", "Error", JOptionPane.ERROR_MESSAGE);
                throw new GeneralException("El rol del usuario obligatorio, para registrarse como usuario");
            }
        } catch (GeneralException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void CleanFormRegisterUser() {
        jTextFieldNombre.setText("");
        jTextFieldApellido.setText("");
        jTextFieldNumeroDocumento.setText("");
        jComboBoxTipoDocumento.setSelectedIndex(0);
        jTextFieldEdad.setText("");
        jDateChooserFechaNacimiento.setDate(null);
        jTextFieldUsuario.setText("");
        jTextFieldClave.setText("");
        jComboBoxRol.setSelectedIndex(0);
    }

    private void CleanFormDeleteUser() {
        jComboBoxUsuario.setSelectedIndex(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new User().setVisible(true);
            } catch (ParseException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEliminarUsuario;
    private javax.swing.JButton jButtonRegistrarUsuario;
    private javax.swing.JComboBox<String> jComboBoxRol;
    private javax.swing.JComboBox<String> jComboBoxTipoDocumento;
    private javax.swing.JComboBox<String> jComboBoxUsuario;
    private com.toedter.calendar.JDateChooser jDateChooserFechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelAyuda;
    private javax.swing.JLabel jLabelClave;
    private javax.swing.JLabel jLabelEdad;
    private javax.swing.JLabel jLabelFechaNacimiento;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNumeroDocumento;
    private javax.swing.JLabel jLabelRol;
    private javax.swing.JLabel jLabelTipoDocumento;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableUsuarios;
    private javax.swing.JTextField jTextFieldApellido;
    private javax.swing.JTextField jTextFieldClave;
    private javax.swing.JTextField jTextFieldEdad;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldNumeroDocumento;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables

}
