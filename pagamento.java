import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class pagamento extends JPanel{
	private JButton btcalcular;
	private JLabel lbpreco,lbjuros,lbparcelas,lbvalororiginal,lbnum;
	private JTextField tfpreco, tfDesconto,tfjuros,tfparcelas;
	private JList lijuros; 
	private JScrollPane spLista;
	
	public pagamento(){
		inicializarComponentes();
		definirEventos();

}

	private void inicializarComponentes() {
	setLayout(null); 
	String[] lijurosItens= {"À vista","12x","24x","36x","48x"};
	btcalcular = new JButton("Calcular");
	lbpreco = new JLabel("Preço");
	lbjuros = new JLabel("Valor Final");
	lbparcelas = new JLabel("Parcelas");
	lbvalororiginal=new JLabel("Valor Original");
	lbnum=new JLabel("");
	tfpreco = new JTextField(5);
	tfparcelas = new JTextField(5);
	tfjuros = new JTextField(5);
	lijuros = new JList(lijurosItens);
	btcalcular.setToolTipText("Faz o cálculo!!");
	spLista = new JScrollPane(lijuros);
	lbpreco.setBounds(35,05,100,25);
	tfpreco.setBounds(35,30,100,25);
	spLista.setBounds(35,60,100,55);
	btcalcular.setBounds(35,120,90,25);
	lbjuros.setBounds(35,160,90,25);
	tfjuros.setBounds(35,180,100,25);
	tfparcelas.setBounds(200,30,100,25);
	lbvalororiginal.setBounds(200,140,100,25);
	lbnum.setBounds(200,160,100,25);
	lbparcelas.setBounds(200,5,100,25);

	add(btcalcular);
	add(lbjuros);
	add(lbparcelas);
	add(tfparcelas);
	add(lbvalororiginal);
	add(lbpreco);
	add(lbnum);
	add(tfpreco);
	add(spLista);
	add(tfjuros);
	}

	 private void definirEventos() {
		 
		 btcalcular.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					if(tfpreco.getText().equals("")){
						tfpreco.requestFocus();
						return;
					}
					float valor = Float.parseFloat(tfpreco.getText());
					if(lijuros.getSelectedIndex()==-1){
						JOptionPane.showMessageDialog(null,"Selecione um item da lista: ");
						return;
					}
					float desconto = 0f;
					if(lijuros.getSelectedIndex()==0){
					
					
					tfjuros.setText(""+ (valor - valor*0.05));
					tfjuros.setEditable(false); 
					lbnum.setText(tfpreco.getText());
					}
					float juros= 0f ;
					
					if(lijuros.getSelectedIndex()==1){
						juros = 0.03f;
						tfjuros.setEditable(false);
						tfjuros.setText(""+(valor + valor*juros*12));
						tfparcelas.setEditable(false);
						tfparcelas.setText(""+(valor + valor*juros*12)/12);
						lbnum.setText(tfpreco.getText());
					}
					if(lijuros.getSelectedIndex()==2){
						juros = 0.05f;
						tfjuros.setEditable(false);
						tfjuros.setText(""+(valor+ valor*juros*24));
						tfparcelas.setEditable(false);
						tfparcelas.setText(""+(valor + valor*juros*24)/24);
						lbnum.setText(tfpreco.getText());
					}
					if(lijuros.getSelectedIndex()==3){
						juros = 0.10f;
						tfjuros.setEditable(false);
						tfjuros.setText(""+(valor + valor*juros*36));
						tfparcelas.setEditable(false);
						tfparcelas.setText(""+(valor + valor*juros*36)/36);
						lbnum.setText(tfpreco.getText());
					}
					if(lijuros.getSelectedIndex()==4){
						juros = 0.15f;
						tfjuros.setEditable(false);
						tfjuros.setText(""+(valor + valor*juros*48));
						tfparcelas.setEditable(false);
						tfparcelas.setText(""+(valor + valor*juros*48)/48);
						lbnum.setText(tfpreco.getText());
					}
					//tfDesconto.setEditable(false); 
					//tfDesconto.setText(" "+valor*desconto);
					//tfjuros.setEditable(false);
					//tfjuros.setText(""+valor*juros);
					
					}
				
			});
	 }
		 public static void main(String args[]){
		 		JFrame frame = new JFrame("AutoVendas");
				 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().add(new pagamento());
				 frame.setBounds(300,300,350,260);
				 frame.setVisible(true);
		 }
























}
