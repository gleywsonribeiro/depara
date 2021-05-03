package br.org.hmue.webreport.modelo.converter;

import br.org.hmue.webreport.modelo.Produto;
import br.org.hmue.webreport.modelo.dao.ProdutoDao;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("produtoConverter")
public class ProdutoConverter implements Converter {

    private ProdutoDao dao = new ProdutoDao();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        System.out.println("Fui chamado objeto!");
        Produto produto;
        if (value == null || value.equals("")) {
            return null;
        }
        try {
            Long id = Long.valueOf(value);
            produto = dao.buscar(id);
            return produto;
        } catch (RuntimeException ex) {
            throw new RuntimeException("Não foi possível converter", ex);

        }

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println("Fui chamado String");
        if (value == null) {
            return "";
        }
        return ((Produto)value).getCodigo().toString();
    }
}
