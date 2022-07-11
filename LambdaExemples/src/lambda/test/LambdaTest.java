package lambda.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaTest {

	public static void main(String[] args) {
		
		
		
		
		// ----------------------------- Operacions bàsiques ------------------------------------------
		
		
		
		
		
		List<String> numerosString = new ArrayList<String>();
		numerosString.add("3");
		numerosString.add("25");
		numerosString.add("69");
		// [3, 25, 69]
		
		
		//Dues linies equivalents, normal i amb Method Reference
		
		numerosString.forEach(n-> System.out.println(n));
		numerosString.forEach(System.out::println);
		/* Print   3
		 *        25
		 *        69
		 */
		
		
		//Tres linies equivalents, normal i amb Method Reference
		
		numerosString.sort((s1,s2)->s1.compareTo(s2));
		numerosString.sort((asdf,dfg)->asdf.compareTo(dfg));
		numerosString.sort(String::compareTo);
		
		//Input [3, 25, 69]
		//Output [25, 3, 69]
		
		
		
		
		
		//Ordenem els elements de la llista de petit a gran implementant un metode "compare" sobreescrit
		Collections.sort(numerosString, new Comparator<String>() {
			@Override
	        public int compare(String s1, String s2) {
	            return Integer.parseInt(s1)-Integer.parseInt(s2);
	        }
		});
		//Input [25, 3, 69]
		//Output [3, 25, 69]
		
		
		
		
		//Passem els elements de la llista a una altra com a Integers
		List<Integer> numeros = numerosString.stream()
											.map(n->Integer.parseInt(n))
											.collect(Collectors.toList());
		//Input [3, 25, 69]  (String)
		//Output [3, 25, 69] (Integer)
		
		
		
		
		
		
		
		//Ara ordenem la llista de gran a petit
		Collections.sort(numeros, new Comparator<Integer>() {
			@Override
			public int compare(Integer n1, Integer n2) {
				return n2-n1;
			}
		});
		//Input [3, 25, 69]
		//Output [69, 25, 3]
		//Equival a: numeros.sort((n1,n2)->n2.compareTo(n1));
		
		
		//Tornem a ordenar creixent
		numeros.sort((n1,n2)->n1.compareTo(n2));
		//Input [69, 25, 3]
		//Output [3, 25, 69]
		//També podem fer numeros.sort(Integer::compareTo);
		
		
		// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Functional Interfaces $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
		
		
		
		// Instanciem la Functional Interface i li donem codi amb una expressió lambda
		// seguint els nombres i tipus de paràmetres i retorn que té el seu mètode
		
		Pepe davant = (s)-> {return "pepe"+s;};
		Pepe darrere = (s)->{return s+"pepe";};
		
		String frase = "Lorem ipsum bla bla bla";
		
		davant.ficarPepe(frase);
		//  pepeLorem ipsum bla bla bla
		
		darrere.ficarPepe(frase);
		//  Lorem ipsum bla bla blapepe
		
		
		
		// Un altre exemple
		
		ComparaEdat algunMajor = (n1,n2) -> { return (n1>=18 || n2>=18); };
		ComparaEdat sonIguals = (n1,n2) -> { return n1==n2; };
		
		algunMajor.CompararEdat(50,2);
		//  true
		
		sonIguals.CompararEdat(50,2);
		//  false
		
		
		
		
		// ################################## STREAM ########################################
		
		
		
		
		
		// Primer creem una llista de samarretes per utilitzar en els exemples
		
		List<Samarreta> samarretes = new ArrayList<Samarreta>();
		samarretes.add(new Samarreta("Vermell","XL",25));    
		samarretes.add(new Samarreta("Vermell","L",15));    
		samarretes.add(new Samarreta("Vermell","M",310));
		samarretes.add(new Samarreta("Blau","XL",23));
		samarretes.add(new Samarreta("Verd","S",14));
		samarretes.add(new Samarreta("Blau","XL",15));
		samarretes.add(new Samarreta("Verd","S",15));
		
		samarretes.forEach(System.out::println);
		
		// Samarreta [color=Vermell, talla=XL, preu=25]
	    // Samarreta [color=Vermell, talla=L, preu=15]
		// Samarreta [color=Vermell, talla=M, preu=310]
		// Samarreta [color=Blau, talla=XL, preu=23]
		// Samarreta [color=Verd, talla=S, preu=14]
		// Samarreta [color=Blau, talla=XL, preu=15]
		// Samarreta [color=Verd, talla=S, preu=15]
		
		
		// Stream es una classe de java.util
		// Serveix per poder recorrer i realitzar operacions en llistes, 
		// i es pot usar en combinacio amb expressions lambda.
		// Generalment s'utilitzen seqüències dels seus mètodes ("Pipeline"), 
		// amb algunes expressions intermitges i una expressió terminal
		
		
		
		
		
		
		
		// Funció inicial ".stream()"
		// Converteix la List que tinguem en un stream (flux) d'elements del tipus corresponent
		Stream<Samarreta> stream = samarretes.stream();
		// Això és un stream de Samarretes
		
		
		
		// - - - - - - - Funcions intermitges - - - - - - -
		
		
		// Funció intermitja ".filter()"
		
		List<Samarreta> samarretesVermelles = samarretes.stream()
														.filter(s->s.getColor().equals("Vermell"))
														.collect(Collectors.toList());
		//Output
		// Samarreta [color=Vermell, talla=XL, preu=25]
	    // Samarreta [color=Vermell, talla=L, preu=15]
		// Samarreta [color=Vermell, talla=M, preu=310]
		
		
		
		
		
		
		samarretes.stream()
		  		  .filter(s->s.getTalla().equals("XL"))
		  		  .forEach(System.out::println);

		// Samarreta [color=Vermell, talla=XL, preu=27]
		// Samarreta [color=Blau, talla=XL, preu=25]
		// Samarreta [color=Blau, talla=XL, preu=15]

		for (int i=0 ; i<samarretes.size() ; i++) {
			if (samarretes.get(i).getTalla().equals("XL")) {
				System.out.println(samarretes.get(i));
			}
		}
		
		
		
		
		
		
		// Funció intermitja ".map()"
		
		
		List<String> infoSamarretes = samarretes.stream()		
				.map(s->s.toString())
				.collect(Collectors.toList());
		
		
		
		
		
		
		// Funció intermitja ".peek()"
		
		List<Samarreta> samarretesCares = samarretes.stream()
				   .filter(s->s.getPreu()>20)
				   .peek(s->{if (s.getPreu()<200) {s.setPreu(s.getPreu()+2);}})
				   .collect(Collectors.toList());
		//Input: samarretes
		//Output: 
		// Samarreta [color=Vermell, talla=XL, preu=27]
		// Samarreta [color=Vermell, talla=M, preu=310]
		// Samarreta [color=Blau, talla=XL, preu=25]
		
		
		// - - - - - - - Funcions terminals - - - - - - - 
		
		
		
		// Funció terminal ".count()"
		
		long numeroVermellesLambda = samarretes.stream()
				  .filter(s -> s.getColor().equals("Vermell"))
				  .peek(System.out::println) 
				  .count();
		
		
		int numeroVermelles = 0;
		for (int i=0 ; i<samarretes.size() ; i++) {
			if (samarretes.get(i).getColor().equals("Vermell")) {
				numeroVermelles++;
			}
		}
		//Output: 3
	
		
		
		// Funció terminal ".sum()"
		
		// Cal fer un mapToInt, mapToDouble, etc abans
		int preuTotalLambda = samarretes.stream()
								  .mapToInt(s->s.getPreu())
								  .sum();
		
		
		int preuTotal = 0;
		for(int i=0 ; i<samarretes.size() ; i++) {
			preuTotal += samarretes.get(i).getPreu();
		}
		//Output: 421
	
		
		

		
		// Funció terminal ".reduce()"

        //Aplica el mètode que hem creat amb una lambda al stream corresponent

        int preuTotalReduce = samarretes.stream().mapToInt(Samarreta::getPreu).reduce(0, (s1, s2) -> s1 + s2);

        //També: samarretes.stream().mapToInt(Samarreta::getPreu).reduce(0, Integer::sum);



        
        

        //Funció terminal ".findFirst()"

        //Ens retorna el primer element d'un stream que compleix la condició, wrappejat en un Optional

        Optional<Samarreta> samarretaOptional = samarretes.stream().filter(s -> s.getTalla().equals("S")).findFirst();

        //Hem de tractar l'Optional:

        samarretaOptional.ifPresentOrElse(samarreta -> System.out.println(samarreta),
                () -> System.out.println("No s'ha trobat cap samarreta d'aquesta talla"));

        //Equivalent:

        //samarretaOptional.ifPresentOrElse(System.out::println,
        //        () -> System.out.println("No s'ha trobat cap samarreta d'aquesta talla"));

	
		
        
        
        //Operació terminal "forEach()"
        System.out.println();
		samarretes.stream()
				  .sorted(Comparator.comparingInt(Samarreta::getPreu))
				  .forEach(s->System.out.println(s.getPreu()));
			//14  15  15  15  25  27  310
		
		
		
		samarretes.stream()
				  .filter(s->s.getTalla().equals("XL"))
				  .forEach(s->s.emprovar());
		// Aquesta samarreta de color Vermell et queda genial!
		// Aquesta samarreta de color Blau et queda genial!
		// Aquesta samarreta de color Blau et queda genial!
		
		
		
		samarretes.stream()
				  .filter(s->s.getTalla().equals("L"))
				  .forEach(s->{s.setColor(s.getColor().toUpperCase());
				  				System.out.println(s);});
		// Samarreta [color=VERMELL, talla=L, preu=15]

		
		samarretes.forEach(System.out::println);
		/* 
		Samarreta [color=Vermell, talla=XL, preu=27]
		Samarreta [color=VERMELL, talla=L, preu=15]
		Samarreta [color=Vermell, talla=M, preu=310]
		Samarreta [color=Blau, talla=XL, preu=25]
		Samarreta [color=Verd, talla=S, preu=14]
		Samarreta [color=Blau, talla=XL, preu=15]
		Samarreta [color=Verd, talla=S, preu=15]
		*/
		
		
		
		
		
		
		//Operacions terminals ".collect()" i ".toArray()"
        

		List<String> tallesDisponibles = samarretes.stream()
												   .map(s->s.getTalla())
												   .distinct()
												   .collect(Collectors.toList());
		//Output: [XL, L, M, S]
		
		
		
		
	
		Samarreta[] blaves = samarretes.stream()
									   .filter(s->s.getColor().equalsIgnoreCase("Blau"))
									   .toArray(Samarreta[]::new);
		//Output: 
		// Samarreta [color=Blau, talla=XL, preu=25]
		// Samarreta [color=Blau, talla=XL, preu=15]
        
		
		
		
		
		// Algunes altres operacions terminals
		
		
		//true
		System.out.println(samarretes.stream()
									 .map(Samarreta::getColor)
									 .anyMatch(s->s.equals("Verd")));
		
		//false
		System.out.println(samarretes.stream()
									 .map(Samarreta::getPreu)
									 .anyMatch(s->s<0));
		
		
		//true
		System.out.println(samarretes.stream()
									 .map(s->s.getTalla())
									 .filter(s->s.equals("XL"))
									 .noneMatch(s->s.equals("S")));
		
		
		
		
		
		
		
		
		
		
		
		

		
	
		
	}
}
