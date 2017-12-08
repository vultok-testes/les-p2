package events;

/**
 * Classe responsável pela criação de eventos aleatórios;
 * 
 * @author elton
 *
 */
public class EventGeneratorImpl implements EventGenerator {
	private int[] possibilities;
	private boolean[] willTrigger;

	public EventGeneratorImpl() {
		willTrigger = new boolean[] {true, false, false, false, false};
		possibilities = fillVector();
	}

	@Override
	public Event generateEvent() {
		boolean triggerEvent = willTriggerAnEvent();

		if (triggerEvent) {
			Event e = new Event();
			e.setType(generateEventType());
			generateEventDetails(e);
			
			return e;
		} else {
			return null;
		}
	}

	/**
	 * Método serve para determinar se um evento será ou não desencadeado.<br>
	 * Há uma possibilidade de <strong>20%</strong> de desencadear.
	 * @return <code> true </code> - se um evento será desencadeado; <br>
	 *         <code> false </code> - se nenhum evento deverá ser desencadeado.
	 * 
	 */
	private boolean willTriggerAnEvent() {
		int num = (int) (Math.random() * 5);
		
		return willTrigger[num];
	}
	
	private void generateEventDetails(Event event) {
		int type = event.getType();
		int totalPossibilities;
		int index = 0;
		
		switch(type) {
		case Event.COMUM:
			totalPossibilities = Event.COMUM_DESC.length;
			index = (int) (Math.random() * totalPossibilities);
			
			event.setDesc(Event.COMUM_DESC[index]);
			event.setFator(Event.COMUM_FATOR[index]);
			event.setAtributoAfetado(Event.COMUM_ATRIB);
			break;
		case Event.INCOMUM:
			totalPossibilities = Event.INCOMUM_DESC.length;
			index = (int) (Math.random() * totalPossibilities);
			
			event.setDesc(Event.INCOMUM_DESC[index]);
			event.setFator(Event.INCOMUM_FATOR[index]);
			event.setAtributoAfetado(Event.COMUM_ATRIB);
			break;
		case Event.WTF:
			totalPossibilities = Event.WTF_DESC.length;
			index = (int) (Math.random() * totalPossibilities);
			
			event.setDesc(Event.WTF_DESC[index]);
			event.setFator(Event.WTF_FATOR[index]);
			event.setAtributoAfetado(Event.WTF_ATRIB);
			break;
		case Event.RARO:
			totalPossibilities = Event.RARO_DESC.length;
			index = (int) (Math.random() * totalPossibilities);
			
			event.setDesc(Event.RARO_DESC[index]);
			event.setFator(Event.RARO_FATOR[index]);
			event.setAtributoAfetado(Event.RARO_ATRIB);
			break;
		case Event.ULTRA_RARO:
			totalPossibilities = Event.ULTRA_RARO_DESC.length;
			index = (int) (Math.random() * totalPossibilities);
			
			event.setDesc(Event.ULTRA_RARO_DESC[index]);
			event.setFator(Event.ULTRA_RARO_FATOR[index]);
			event.setAtributoAfetado(Event.ULTRA_RARO_ATRIB);
			break;
		}
	}
	
	/**
	 * Método aleatóriamente gera um tipo para o evento.
	 * 
	 * @return tipo do evento.
	 */
	private int generateEventType() {
		int num = (int) (Math.random() * 100);
		
		return possibilities[num];
	}

	private int[] fillVector() {
		int i;
		int[] temp = new int[100];

		// 0-73 = Comum
		for (i = 0; i < 74; i++) {
			temp[i] = Event.COMUM;
		}
		// 74-88 = Incomum
		for (/* i = 74 */; i < 89; i++) {
			temp[i] = Event.INCOMUM;
		}
		// 89-93 = WTF
		for (/* i = 89 */; i < 94; i++) {
			temp[i] = Event.WTF;
		}
		// 94-98 = RARO
		for (/* i = 94 */; i < 99; i++) {
			temp[i] = Event.RARO;
		}
		// 99 = ULTRA_RARO
		temp[i] = Event.ULTRA_RARO;

		return temp;
	}

	// Apenas curiosidade
	public static void main(String[] args) {
		EventGeneratorImpl e = new EventGeneratorImpl();
		
		/*
		for (int j = 0; j < 10; j++) {
			int[] sample = new int[5];

			for (int i = 0; i < 100; i++) {
				sample[e.generateEventType()]++;
			}

			System.out.println("74%: " + sample[0] + " - 15%: " + sample[1] 
					+ " - 5%: " + sample[2] + " - 5%: " + sample[3] + " - 1%: " + sample[4]);
		}*/
		
		for(int i = 0; i < 20; i++) {
			Event ev = e.generateEvent();
			if(ev != null) {
				System.out.println(ev.getType() + " " + ev.getDesc() + " " + (1D + ev.getFator()));
			}
		}
	}
}
