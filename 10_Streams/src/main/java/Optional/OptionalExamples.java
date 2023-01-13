package Optional;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalLong;

public class OptionalExamples {

	public static void main(String[] args) {

		// optional vazio
		Optional<Object> empty = Optional.empty();

		// optional de inteiro
		Optional<Integer> opInt = Optional.of(95);

		// obtem valor do optional
		int integer = opInt.get();

		// imprimir um optional
		System.out.println(opInt); // Optional[95]

		// imprimir um optional.get
		System.out.println(opInt.get()); // 95

		// verificar se optional contain valor
		if (opInt.isPresent()) {
			System.out.println("optInt is present");
		}

		if (empty.isEmpty()) {
			System.out.println("empty is empty");
		}

		// acessar optional se nao existe
		try {
			System.out.println(empty.get());
		} catch (NoSuchElementException e) {
			System.out.println("Throw NoSuchElementException");
		}

		// ao inves de fazer if else para atribuir valor
		Optional<Integer> ofNullable = Optional.ofNullable(66);

		// se empty for vazio, retorna o valor 89
		// orElse(T other)
		System.out.println(empty.orElse(89));
		System.out.println(opInt.orElse(89));
		// mesmo possuindo valor, o metodo foi executado
		System.out.println(opInt.orElse(checkIfIsProcessed()));

		// orElseGet(Supplier s)
		// generate a value at runtime
		System.out.println(empty.orElseGet(() -> generateValue()));
		System.out.println(opInt.orElseGet(() -> checkIfIsProcessed())); // not processed

		try {
			// orElseThrow()
			System.out.println(empty.orElseThrow());
			// lanca a excecao NoSuchElementException
		} catch (NoSuchElementException e) {
		}

		try {
			// orElseThrow(Supplier s)
			System.out.println(empty.orElseThrow(() -> new IllegalStateException()));
			// lanca uma custom exception
//			we do not write throw new IllegalStateException().
//			The orElseThrow() method takes care of actually throwing the exception when we run it.
		} catch (IllegalStateException e) {
		}

		
		//executa metodo se existir
		opInt.ifPresent(conteudoDoOptional -> System.out.println("ifPresent " + conteudoDoOptional));
		
		
		//se nao existir valor, seta default
		String nullName = null;
		Optional.ofNullable(nullName).orElse("john");
	}
	
	
	//permite filtrar o valor do optional
//	public boolean priceIsInRange2(Modem modem2) {
//	     return Optional.ofNullable(modem2)
//	       .map(Modem::getPrice)
//	       .filter(p -> p >= 10)
//	       .filter(p -> p <= 15)
//	       .isPresent();
//	 }
	

	public static Integer generateValue() {
		return 123;
	}

	public static Integer checkIfIsProcessed() {
		System.out.println("Was processed");
		return 456;
	}

}
