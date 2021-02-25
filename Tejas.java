import com.opencsv.*;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException, CsvException {
		Reader reader = Files.newBufferedReader(Paths.get("C:\\Users\\Hp\\Desktop\\JAVA internshala\\taskFileSystem\\Car_sales.csv"));


		//parser! scan from left to right
		CSVParser parser = new CSVParserBuilder()
				.withSeparator('\t')
				.build();


		CSVReader obj = new CSVReaderBuilder(reader)
				.withCSVParser(parser)
				.build();


		//read the contents of the file
		List<String[]> data=obj.readAll();  //return a list of string from the file

		data = new LinkedList<>();
		List<String[]> finalData = data;
		data.stream()
				.filter(x->x[0].equalsIgnoreCase("buick"))
				.forEach(x-> finalData.add(x));
		data.stream().filter(x -> !x[2].equalsIgnoreCase("__year_resale_value"))// Use to avoid NumberFormatException for 1st line
				.forEach(x-> System.out.println(x));

	}

}
