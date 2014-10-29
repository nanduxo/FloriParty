package Util;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;

public class UploadImageUtil {
	private static final String DIRETORIO_IMAGENS = "/resources/img/upload/";
	public static final Map<String, String> TIPOS = new HashMap<String, String>();
	
	static {
		TIPOS.put("image/jpeg", "jpg");
		TIPOS.put("image/png", "png");
		TIPOS.put("image/gif", "gif");
	}
	
	public static String copiar(Part imagem, String imagemAntiga)
			throws IOException {

		if (imagem == null)
			return imagemAntiga;
		
		String nomeImagem = gerarNomeImagem(imagem);

		imagem.write(getCaminhoAbsoluto(nomeImagem));
		
		deletar(imagemAntiga);
		
		return nomeImagem;
	}
	
	public static void deletar(String nomeImagem) {
		if (nomeImagem == null)
			return;

		File file = new File(getCaminhoAbsoluto(nomeImagem));
		if (file.exists())
			file.delete();
	}

	private static String getExtensao(Part imagem) {
		return TIPOS.get(imagem.getContentType());
	}

	
	private static String gerarNomeImagem(Part imagem) {
		if (!TIPOS.containsKey(imagem.getContentType()))
			return null;

		String extensao = ".".concat(getExtensao(imagem));
		
		String nome = UUID.randomUUID().toString();
		return nome.concat(extensao);
	}
	

	public static String getCaminhoAbsoluto(String nomeImagem) {
		String relativeWebPath = DIRETORIO_IMAGENS.concat(nomeImagem);
		ServletContext servletContext = (ServletContext) FacesContext
				.getCurrentInstance().getExternalContext().getContext();
		String absoluteDiskPath = servletContext.getRealPath(relativeWebPath);
		return absoluteDiskPath;
	}

	public static String getCaminho(String nomeImagem) {
		return DIRETORIO_IMAGENS.concat(nomeImagem);
	}
}
