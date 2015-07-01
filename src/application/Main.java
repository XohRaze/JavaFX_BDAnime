package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	
	private static final String String = null;
	//botoes
	Button btnok = new Button("login");	//ok no login
	Button btncriar = new Button("Criar");	//botao para criar anime
	Button btnEditar = new Button("Editar");	//botao para editar anime
	Button btnApagar = new Button("Apagar");  //botao para apagar anime
	Button btnatras = new Button("Voltar"); //voltar atras
	Button btnAdicionar = new Button("criar"); //button criar anime
	Button btnRefresh = new Button("Refresh");
	
	
	//labels
	Label labelUserName = new Label("Username: ");
	Label labelPassword = new Label("Password: ");
	Label labelnome = new Label("Nome: ");
	Label labeltipo = new Label("Tipo: ");
	Label labelnrEpisodios = new Label("Nr Episodios: ");
	Label labelsinopse = new Label("Sinopse: ");
	Label labelcomentario = new Label("Comentario: ");
	
	//TextFields
	TextField textFieldUserName = new TextField();
	PasswordField passwordFieldPassword = new PasswordField();
	TextField nomefield = new TextField();
	TextField tipofield = new TextField();
	TextField nrEpisodios = new TextField();
	TextField sinopse = new TextField();
	TextField comentario = new TextField();
	
	//imageView
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//adicionar a grid ao layout principal
			GridPane root = new GridPane();	//login
			GridPane root2 = new GridPane();	//usuario admin
			GridPane criar = new GridPane();	//criar animes
			
			
			Scene scene = new Scene(root,400,400);		//scena da conta
			Scene scene2 = new Scene(root2,1000, 1000);	//scena do admin
			Scene scene4 = new Scene(criar,500,500);	//scena para criar anime
			
			
			/*-----------------conta------------------------------*/
			root.add(labelUserName, 0, 0);
			root.add(textFieldUserName, 1, 0);
			root.add(labelPassword, 0, 2);
			root.add(passwordFieldPassword, 1,2);
			root.add(btnok, 1, 3);
			
			btnok.setOnAction(e->{
					primaryStage.setScene(scene2);
			});
			
			
			/*------------admin------------------------------------*/
			//adicionar a grid 2 para ver a list e os botoes
			root2.add(btncriar, 0, 0);
			root2.add(btnEditar, 1, 0);
			root2.add(btnApagar, 2, 0);
			root2.add(btnRefresh, 3,0);
			
			
			
			btncriar.setOnAction(e->{
				primaryStage.setScene(scene4);
			});
			
			btnRefresh.setOnAction(e->{
				TableView<Anime> tableAnime = new TableView<>();
				
				TableColumn<Anime,String> colunaNome= new TableColumn<>("Nome");
				colunaNome.setMinWidth(200);
				colunaNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
				
				TableColumn<Anime,String> colunaTipo= new TableColumn<>("Tipo");
				colunaTipo.setMinWidth(200);
				colunaTipo.setCellValueFactory(new PropertyValueFactory<>("Tipo"));
				
				
				TableColumn<Anime,String> colunanrEpisodios= new TableColumn<>("nr.Episodios");
				colunanrEpisodios.setMinWidth(200);
				colunanrEpisodios.setCellValueFactory(new PropertyValueFactory<>(" NEpisodios"));
				
				
				TableColumn<Anime,String> colunaSinopse= new TableColumn<>("Sinopse");
				colunaSinopse.setMinWidth(200);
				colunaSinopse.setCellValueFactory(new PropertyValueFactory<>("Sinopse"));
				
				
				TableColumn<Anime,String> colunaComentario= new TableColumn<>("Comentario");
				colunaComentario.setMinWidth(200);
				colunaComentario.setCellValueFactory(new PropertyValueFactory<>("Comentario"));
				
				
				
				tableAnime.getColumns().addAll(colunaNome, colunaTipo, colunanrEpisodios, colunaSinopse, colunaComentario);
				tableAnime.setItems(carregaListAnimes());
				
				root2.add(tableAnime, 4,5);
			});
			
			
			/*------------------------------------------------------------------*/
			//adicionar a gridpane para poder criar animes
			criar.add(labelnome, 2, 0);
			criar.add(nomefield,3,0);
			criar.add(labeltipo, 2, 1);
			criar.add(tipofield,3,1);
			criar.add(labelnrEpisodios, 2, 2);
			criar.add(nrEpisodios,3,2);
			criar.add(labelsinopse, 2, 3);
			criar.add(sinopse,3,3);
			criar.add(labelcomentario, 2,4);
			criar.add(comentario, 3,4);
			criar.add(btnAdicionar, 2,5);
			criar.add(btnatras, 3,5);
			
			//btn voltar
			btnatras.setOnAction(e->{
				primaryStage.setScene(scene2);
			});
			//btnadicionar anime
			btnAdicionar.setOnAction(e->{
				
				Anime a = new Anime();
				
				a.setNome(nomefield.getText());	
				a.setTipo(tipofield.getText());	
				a.setNEpisodios(Integer.parseInt(nrEpisodios.getText()));	
				a.setSinopse(sinopse.getText());	
				a.setComentario(comentario.getText());
				
				dicionario.setlistAnimes(a);
				
				primaryStage.setScene(scene2);
				
			});
			/*------------------------------------------------------------------*/
			
			TableView<Anime> tableAnime = new TableView<>();
			
			TableColumn<Anime,String> colunaNome= new TableColumn<>("Nome");
			colunaNome.setMinWidth(200);
			colunaNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
			
			TableColumn<Anime,String> colunaTipo= new TableColumn<>("Tipo");
			colunaTipo.setMinWidth(200);
			colunaTipo.setCellValueFactory(new PropertyValueFactory<>("Tipo"));
			
			
			TableColumn<Anime,String> colunanrEpisodios= new TableColumn<>("nr.Episodios");
			colunanrEpisodios.setMinWidth(200);
			colunanrEpisodios.setCellValueFactory(new PropertyValueFactory<>(" NEpisodios"));
			
			
			TableColumn<Anime,String> colunaSinopse= new TableColumn<>("Sinopse");
			colunaSinopse.setMinWidth(200);
			colunaSinopse.setCellValueFactory(new PropertyValueFactory<>("Sinopse"));
			
			
			TableColumn<Anime,String> colunaComentario= new TableColumn<>("Comentario");
			colunaComentario.setMinWidth(200);
			colunaComentario.setCellValueFactory(new PropertyValueFactory<>("Comentario"));
			
			
			
			tableAnime.getColumns().addAll(colunaNome, colunaTipo, colunanrEpisodios, colunaSinopse, colunaComentario);
			tableAnime.setItems(carregaListAnimes());
			/*-------------------------------------------------------------------*/
			
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	private ObservableList<Anime> carregaListAnimes()
	{
		ObservableList<Anime> listAnimes = FXCollections.observableArrayList();
		
		for(int key : dicionario.listAnimes.keySet()){
			Anime b = dicionario.listAnimes.get(key);
			listAnimes.add(new Anime(b.getNome(), b.getTipo(), b.getNEpisodios(), b.getSinopse(), b.getComentario()));
		}
		
		return listAnimes;
	}
	
	
}
