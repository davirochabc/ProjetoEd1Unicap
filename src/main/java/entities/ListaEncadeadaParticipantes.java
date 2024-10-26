
package entities;

/**
 *
 * @author j040v
 */
public class ListaEncadeadaParticipantes {
    private NodoParticipante head;

    
    public void inserirParticipante(ParticipanteEvento participante) {
        NodoParticipante newNode = new NodoParticipante(participante);
        if (head == null) {
            head = newNode;
        } else {
            NodoParticipante temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

   
    public void exibirParticipantes() {
        if (head == null) {
            System.out.println("Nenhum participante na lista.");
            return;
        }

        NodoParticipante temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    
    public void removerParticipante(String nome) {
        if (head == null) return;

        if (head.data.getName().equals(nome)) {
            head = head.next;
            return;
        }

        NodoParticipante temp = head;
        while (temp.next != null && !temp.next.data.getName().equals(nome)) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }
}
