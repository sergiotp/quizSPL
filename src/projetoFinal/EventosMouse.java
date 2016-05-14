package projetoFinal;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EventosMouse extends MouseAdapter{
	
	Imagem imagem;
	
	protected EventosMouse(Imagem imagem) {
		this.imagem = imagem;
	}
	
	public void mouseClicked(MouseEvent e) {
		if(this.imagem.imagensViradas() == 0){
			this.imagem.virarImagem();
		}else if(this.imagem.imagensViradas() == 1){
			if(this.imagem.getNumeroVirada() == this.imagem.getNumero() &&
				this.imagem.getSequencialVirada() == this.imagem.getSequencial()){
				return;
			}
			this.imagem.virarImagem();
			this.imagem.verificarIguais();
		}
		
		
	}

	
}
