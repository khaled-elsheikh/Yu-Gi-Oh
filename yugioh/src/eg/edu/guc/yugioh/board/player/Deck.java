package eg.edu.guc.yugioh.board.player;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import org.omg.CORBA.portable.UnknownException;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.CardDestruction;
import eg.edu.guc.yugioh.cards.spells.ChangeOfHeart;
import eg.edu.guc.yugioh.cards.spells.DarkHole;
import eg.edu.guc.yugioh.cards.spells.GracefulDice;
import eg.edu.guc.yugioh.cards.spells.HarpieFeatherDuster;
import eg.edu.guc.yugioh.cards.spells.HeavyStorm;
import eg.edu.guc.yugioh.cards.spells.MagePower;
import eg.edu.guc.yugioh.cards.spells.MonsterReborn;
import eg.edu.guc.yugioh.cards.spells.PotOfGreed;
import eg.edu.guc.yugioh.cards.spells.Raigeki;
import eg.edu.guc.yugioh.exceptions.EmptyFieldException;
import eg.edu.guc.yugioh.exceptions.MissingFieldException;
import eg.edu.guc.yugioh.exceptions.UnexpectedFormatException;
import eg.edu.guc.yugioh.exceptions.UnknownCardTypeException;
import eg.edu.guc.yugioh.exceptions.UnknownSpellCardException;

public class Deck {
	private static ArrayList<Card> monsters=new ArrayList<Card>();
	private static ArrayList<Card> spells=new ArrayList<Card>();
	private	ArrayList<Card> deck = new ArrayList<Card>();
	private static String monstersPath = "data/Database-Monsters.csv";
	private static String spellsPath = "data/Database-Spells.csv";
	@SuppressWarnings("static-access")
	public Deck() throws IOException, UnexpectedFormatException{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String in = "";
		try {
			this.monsters = loadCardsFromFile(monstersPath);
		}
		catch (FileNotFoundException f) {
			System.out.println("Please enter a correct path for the monsters database: "); //1
			in = sc.nextLine();
			try {
				this.monsters = loadCardsFromFile(in);
			}
			catch (FileNotFoundException f2) {
				System.out.println("The file was not found.\nPlease enter a correct path for the monsters database: "); //2
				in = sc.nextLine();
				try {
					this.monsters = loadCardsFromFile(in);
				}
				catch (FileNotFoundException f3) {
					System.out.println("The file was not found.\nPlease enter a correct path for the monsters database: ");
					in = sc.nextLine();
					try {
						this.monsters = loadCardsFromFile(in);
					}
					catch (FileNotFoundException f5) {
						f5.printStackTrace();
						throw f5;
					}
					catch (UnexpectedFormatException f5) {
						f5.printStackTrace();
						throw f5;
					}
				}
				catch (UnexpectedFormatException m)
				{
					if (m instanceof MissingFieldException) {
						System.out.println("Line number " + m.getSourceLine() + " in file " + m.getSourceFile() 
								+ " is malformed.(Missing Field)\nPlease enter a correct path: ");
					}
					if (m instanceof EmptyFieldException) {
						System.out.println("Line number " + m.getSourceLine() + " in file " + m.getSourceFile() 
								+ " is malformed.(Field " + ((EmptyFieldException)m).getSourceField()
								+ " is empty)\nPlease enter a correct path: ");
					}
					if (m instanceof UnknownCardTypeException) {
						System.out.println("Line number " + m.getSourceLine() + " in file " + m.getSourceFile() 
								+ " is malformed.(Unknown Card Type: " + ((UnknownCardTypeException)m).getUnknownType()
								+ ")\nPlease enter a correct path: ");
					}
					if (m instanceof UnknownSpellCardException) {
						System.out.println("Line number " + m.getSourceLine() + " in file " + m.getSourceFile() 
								+ " is malformed.(Unknown Spell Card: " + ((UnknownSpellCardException)m).getUnknownSpell()
								+ ")\nPlease enter a correct path: ");
					}
					in = sc.nextLine();
					try {
						this.monsters = loadCardsFromFile(in);
					}
					catch (FileNotFoundException f5) {
						f5.printStackTrace();
						throw f5;
					}
					catch (UnexpectedFormatException as) {
						as.printStackTrace();
						throw as;
					}
				}
			}
			catch (UnexpectedFormatException a) {
				if (a instanceof MissingFieldException) {
					System.out.println("Line number " + a.getSourceLine() + " in file " + a.getSourceFile() 
							+ " is malformed.(Missing Field)\nPlease enter a correct path: ");
				}
				if (a instanceof EmptyFieldException) {
					System.out.println("Line number " + a.getSourceLine() + " in file " + a.getSourceFile() 
							+ " is malformed.(Field " + ((EmptyFieldException)a).getSourceField()
							+ " is empty)\nPlease enter a correct path: ");
				}
				if (a instanceof UnknownCardTypeException) {
					System.out.println("Line number " + a.getSourceLine() + " in file " + a.getSourceFile() 
							+ " is malformed.(Unknown Card Type: " + ((UnknownCardTypeException)a).getUnknownType()
							+ ")\nPlease enter a correct path: ");
				}
				if (a instanceof UnknownSpellCardException) {
					System.out.println("Line number " + a.getSourceLine() + " in file " + a.getSourceFile() 
							+ " is malformed.(Unknown Spell Card: " + ((UnknownSpellCardException)a).getUnknownSpell()
							+ ")\nPlease enter a correct path: ");
				}
				in = sc.nextLine();
				try {
					this.monsters = loadCardsFromFile(in);
				}
				catch (FileNotFoundException f3) {
					System.out.println("The file was not found.\nPlease enter a correct path for the monsters database: ");
					in = sc.nextLine();
					try {
						this.monsters = loadCardsFromFile(in);
					}
					catch (FileNotFoundException f5) {
						f5.printStackTrace();
						throw f5;
					}
					catch (UnexpectedFormatException as) {
						as.printStackTrace();
						throw as;
					}
				}
				catch (UnexpectedFormatException l) {
					if (l instanceof MissingFieldException) {
						System.out.println("Line number " + l.getSourceLine() + " in file " + l.getSourceFile() 
								+ " is malformed.(Missing Field)\nPlease enter a correct path: ");
					}
					if (l instanceof EmptyFieldException) {
						System.out.println("Line number " + l.getSourceLine() + " in file " + l.getSourceFile() 
								+ " is malformed.(Field " + ((EmptyFieldException)l).getSourceField()
								+ " is empty)\nPlease enter a correct path: ");
					}
					if (l instanceof UnknownCardTypeException) {
						System.out.println("Line number " + l.getSourceLine() + " in file " + l.getSourceFile() 
								+ " is malformed.(Unknown Card Type: " + ((UnknownCardTypeException)l).getUnknownType()
								+ ")\nPlease enter a correct path: ");
					}
					if (l instanceof UnknownSpellCardException) {
						System.out.println("Line number " + l.getSourceLine() + " in file " + l.getSourceFile() 
								+ " is malformed.(Unknown Spell Card: " + ((UnknownSpellCardException)l).getUnknownSpell()
								+ ")\nPlease enter a correct path: ");
					}
					in = sc.nextLine();
					try {
						this.monsters = loadCardsFromFile(in);
					}
					catch (FileNotFoundException f5) {
						f5.printStackTrace();
						throw f5;
					}
					catch (UnexpectedFormatException as) {
						as.printStackTrace();
						throw as;
					}
				}
			}
		}
		catch (UnexpectedFormatException s)
		{
			if (s instanceof MissingFieldException) {
				System.out.println("Line number " + s.getSourceLine() + " in file " + s.getSourceFile() 
						+ " is malformed.(Missing Field)\nPlease enter a correct path: ");
			}
			if (s instanceof EmptyFieldException) {
				System.out.println("Line number " + s.getSourceLine() + " in file " + s.getSourceFile() 
						+ " is malformed.(Field " + ((EmptyFieldException)s).getSourceField()
						+ " is empty)\nPlease enter a correct path: ");
			}
			if (s instanceof UnknownCardTypeException) {
				System.out.println("Line number " + s.getSourceLine() + " in file " + s.getSourceFile() 
						+ " is malformed.(Unknown Card Type: " + ((UnknownCardTypeException)s).getUnknownType()
						+ ")\nPlease enter a correct path: ");
			}
			if (s instanceof UnknownSpellCardException) {
				System.out.println("Line number " + s.getSourceLine() + " in file " + s.getSourceFile() 
						+ " is malformed.(Unknown Spell Card: " + ((UnknownSpellCardException)s).getUnknownSpell()
						+ ")\nPlease enter a correct path: ");
			}
			in = sc.nextLine();
			try {
				this.monsters = loadCardsFromFile(in);
			}
			catch (FileNotFoundException f2) {
				System.out.println("The file was not found.\nPlease enter a correct path for the monsters database: "); //2
				in = sc.nextLine();
				try {
					this.monsters = loadCardsFromFile(in);
				}
				catch (FileNotFoundException f3) {
					System.out.println("The file was not found.\nPlease enter a correct path for the monsters database: ");
					in = sc.nextLine();
					try {
						this.monsters = loadCardsFromFile(in);
					}
					catch (FileNotFoundException f5) {
						f5.printStackTrace();
						throw f5;
					}
					catch (UnexpectedFormatException f5) {
						throw f5;
					}
				}
				catch (UnexpectedFormatException m)
				{
					if (m instanceof MissingFieldException) {
						System.out.println("Line number " + m.getSourceLine() + " in file " + m.getSourceFile() 
								+ " is malformed.(Missing Field)\nPlease enter a correct path: ");
					}
					if (m instanceof EmptyFieldException) {
						System.out.println("Line number " + m.getSourceLine() + " in file " + m.getSourceFile() 
								+ " is malformed.(Field " + ((EmptyFieldException)m).getSourceField()
								+ " is empty)\nPlease enter a correct path: ");
					}
					if (m instanceof UnknownCardTypeException) {
						System.out.println("Line number " + m.getSourceLine() + " in file " + m.getSourceFile() 
								+ " is malformed.(Unknown Card Type: " + ((UnknownCardTypeException)m).getUnknownType()
								+ ")\nPlease enter a correct path: ");
					}
					if (m instanceof UnknownSpellCardException) {
						System.out.println("Line number " + m.getSourceLine() + " in file " + m.getSourceFile() 
								+ " is malformed.(Unknown Spell Card: " + ((UnknownSpellCardException)m).getUnknownSpell()
								+ ")\nPlease enter a correct path: ");
					}
					in = sc.nextLine();
					try {
						this.monsters = loadCardsFromFile(in);
					}
					catch (FileNotFoundException f5) {
						f5.printStackTrace();
						throw f5;
					}
					catch (UnexpectedFormatException as) {
						as.printStackTrace();
						throw as;
					}
				}
			}
			catch (UnexpectedFormatException a) {
				if (a instanceof MissingFieldException) {
					System.out.println("Line number " + a.getSourceLine() + " in file " + a.getSourceFile() 
							+ " is malformed.(Missing Field)\nPlease enter a correct path: ");
				}
				if (a instanceof EmptyFieldException) {
					System.out.println("Line number " + a.getSourceLine() + " in file " + a.getSourceFile() 
							+ " is malformed.(Field " + ((EmptyFieldException)a).getSourceField()
							+ " is empty)\nPlease enter a correct path: ");
				}
				if (a instanceof UnknownCardTypeException) {
					System.out.println("Line number " + a.getSourceLine() + " in file " + a.getSourceFile() 
							+ " is malformed.(Unknown Card Type: " + ((UnknownCardTypeException)a).getUnknownType()
							+ ")\nPlease enter a correct path: ");
				}
				if (a instanceof UnknownSpellCardException) {
					System.out.println("Line number " + a.getSourceLine() + " in file " + a.getSourceFile() 
							+ " is malformed.(Unknown Spell Card: " + ((UnknownSpellCardException)a).getUnknownSpell()
							+ ")\nPlease enter a correct path: ");
				}
				in = sc.nextLine();
				try {
					this.monsters = loadCardsFromFile(in);
				}
				catch (FileNotFoundException f3) {
					System.out.println("The file was not found.\nPlease enter a correct path for the monsters database: ");
					in = sc.nextLine();
					try {
						this.monsters = loadCardsFromFile(in);
					}
					catch (FileNotFoundException f5) {
						f5.printStackTrace();
						throw f5;
					}
					catch (UnexpectedFormatException as) {
						as.printStackTrace();
						throw as;
					}
				}
				catch (UnexpectedFormatException l) {
					if (l instanceof MissingFieldException) {
						System.out.println("Line number " + l.getSourceLine() + " in file " + l.getSourceFile() 
								+ " is malformed.(Missing Field)\nPlease enter a correct path: ");
					}
					if (l instanceof EmptyFieldException) {
						System.out.println("Line number " + l.getSourceLine() + " in file " + l.getSourceFile() 
								+ " is malformed.(Field " + ((EmptyFieldException)l).getSourceField()
								+ " is empty)\nPlease enter a correct path: ");
					}
					if (l instanceof UnknownCardTypeException) {
						System.out.println("Line number " + l.getSourceLine() + " in file " + l.getSourceFile() 
								+ " is malformed.(Unknown Card Type: " + ((UnknownCardTypeException)l).getUnknownType()
								+ ")\nPlease enter a correct path: ");
					}
					if (l instanceof UnknownSpellCardException) {
						System.out.println("Line number " + l.getSourceLine() + " in file " + l.getSourceFile() 
								+ " is malformed.(Unknown Spell Card: " + ((UnknownSpellCardException)l).getUnknownSpell()
								+ ")\nPlease enter a correct path: ");
					}
					in = sc.nextLine();
					try {
						this.monsters = loadCardsFromFile(in);
					}
					catch (FileNotFoundException f5) {
						f5.printStackTrace();
						throw f5;
					}
					catch (UnexpectedFormatException as) {
						as.printStackTrace();
						throw as;
					}
				}
			}
		}
		try {
			this.spells = loadCardsFromFile(spellsPath);
		}
		catch (FileNotFoundException f) {
			System.out.println("Please enter a correct path for the spells database: "); //1
			in = sc.nextLine();
			try {
				this.spells = loadCardsFromFile(in);
			}
			catch (FileNotFoundException f2) {
				System.out.println("The file was not found.\nPlease enter a correct path for the spells database: "); //2
				in = sc.nextLine();
				try {
					this.spells = loadCardsFromFile(in);
				}
				catch (FileNotFoundException f3) {
					System.out.println("The file was not found.\nPlease enter a correct path for the spells database: ");
					in = sc.nextLine();
					try {
						this.spells = loadCardsFromFile(in);
					}
					catch (FileNotFoundException f5) {
						f5.printStackTrace();
						throw f5;
					}
					catch (UnexpectedFormatException f5) {
						f5.printStackTrace();
						throw f5;
					}
				}
				catch (UnexpectedFormatException m)
				{
					if (m instanceof MissingFieldException) {
						System.out.println("Line number " + m.getSourceLine() + " in file " + m.getSourceFile() 
								+ " is malformed.(Missing Field)\nPlease enter a correct path: ");
					}
					if (m instanceof EmptyFieldException) {
						System.out.println("Line number " + m.getSourceLine() + " in file " + m.getSourceFile() 
								+ " is malformed.(Field " + ((EmptyFieldException)m).getSourceField()
								+ " is empty)\nPlease enter a correct path: ");
					}
					if (m instanceof UnknownCardTypeException) {
						System.out.println("Line number " + m.getSourceLine() + " in file " + m.getSourceFile() 
								+ " is malformed.(Unknown Card Type: " + ((UnknownCardTypeException)m).getUnknownType()
								+ ")\nPlease enter a correct path: ");
					}
					if (m instanceof UnknownSpellCardException) {
						System.out.println("Line number " + m.getSourceLine() + " in file " + m.getSourceFile() 
								+ " is malformed.(Unknown Spell Card: " + ((UnknownSpellCardException)m).getUnknownSpell()
								+ ")\nPlease enter a correct path: ");
					}
					in = sc.nextLine();
					try {
						this.spells = loadCardsFromFile(in);
					}
					catch (FileNotFoundException f5) {
						f5.printStackTrace();
						throw f5;
					}
					catch (UnexpectedFormatException as) {
						as.printStackTrace();
						throw as;
					}
				}
			}
			catch (UnexpectedFormatException a) {
				if (a instanceof MissingFieldException) {
					System.out.println("Line number " + a.getSourceLine() + " in file " + a.getSourceFile() 
							+ " is malformed.(Missing Field)\nPlease enter a correct path: ");
				}
				if (a instanceof EmptyFieldException) {
					System.out.println("Line number " + a.getSourceLine() + " in file " + a.getSourceFile() 
							+ " is malformed.(Field " + ((EmptyFieldException)a).getSourceField()
							+ " is empty)\nPlease enter a correct path: ");
				}
				if (a instanceof UnknownCardTypeException) {
					System.out.println("Line number " + a.getSourceLine() + " in file " + a.getSourceFile() 
							+ " is malformed.(Unknown Card Type: " + ((UnknownCardTypeException)a).getUnknownType()
							+ ")\nPlease enter a correct path: ");
				}
				if (a instanceof UnknownSpellCardException) {
					System.out.println("Line number " + a.getSourceLine() + " in file " + a.getSourceFile() 
							+ " is malformed.(Unknown Spell Card: " + ((UnknownSpellCardException)a).getUnknownSpell()
							+ ")\nPlease enter a correct path: ");
				}
				in = sc.nextLine();
				try {
					this.spells = loadCardsFromFile(in);
				}
				catch (FileNotFoundException f3) {
					System.out.println("The file was not found.\nPlease enter a correct path for the spells database: ");
					in = sc.nextLine();
					try {
						this.spells = loadCardsFromFile(in);
					}
					catch (FileNotFoundException f5) {
						f5.printStackTrace();
						throw f5;
					}
					catch (UnexpectedFormatException as) {
						as.printStackTrace();
						throw as;
					}
				}
				catch (UnexpectedFormatException l) {
					if (l instanceof MissingFieldException) {
						System.out.println("Line number " + l.getSourceLine() + " in file " + l.getSourceFile() 
								+ " is malformed.(Missing Field)\nPlease enter a correct path: ");
					}
					if (l instanceof EmptyFieldException) {
						System.out.println("Line number " + l.getSourceLine() + " in file " + l.getSourceFile() 
								+ " is malformed.(Field " + ((EmptyFieldException)l).getSourceField()
								+ " is empty)\nPlease enter a correct path: ");
					}
					if (l instanceof UnknownCardTypeException) {
						System.out.println("Line number " + l.getSourceLine() + " in file " + l.getSourceFile() 
								+ " is malformed.(Unknown Card Type: " + ((UnknownCardTypeException)l).getUnknownType()
								+ ")\nPlease enter a correct path: ");
					}
					if (l instanceof UnknownSpellCardException) {
						System.out.println("Line number " + l.getSourceLine() + " in file " + l.getSourceFile() 
								+ " is malformed.(Unknown Spell Card: " + ((UnknownSpellCardException)l).getUnknownSpell()
								+ ")\nPlease enter a correct path: ");
					}
					in = sc.nextLine();
					try {
						this.spells = loadCardsFromFile(in);
					}
					catch (FileNotFoundException f5) {
						f5.printStackTrace();
						throw f5;
					}
					catch (UnexpectedFormatException as) {
						as.printStackTrace();
						throw as;
					}
				}
			}
		}
		catch (UnexpectedFormatException s)
		{
			if (s instanceof MissingFieldException) {
				System.out.println("Line number " + s.getSourceLine() + " in file " + s.getSourceFile() 
						+ " is malformed.(Missing Field)\nPlease enter a correct path: ");
			}
			if (s instanceof EmptyFieldException) {
				System.out.println("Line number " + s.getSourceLine() + " in file " + s.getSourceFile() 
						+ " is malformed.(Field " + ((EmptyFieldException)s).getSourceField()
						+ " is empty)\nPlease enter a correct path: ");
			}
			if (s instanceof UnknownCardTypeException) {
				System.out.println("Line number " + s.getSourceLine() + " in file " + s.getSourceFile() 
						+ " is malformed.(Unknown Card Type: " + ((UnknownCardTypeException)s).getUnknownType()
						+ ")\nPlease enter a correct path: ");
			}
			if (s instanceof UnknownSpellCardException) {
				System.out.println("Line number " + s.getSourceLine() + " in file " + s.getSourceFile() 
						+ " is malformed.(Unknown Spell Card: " + ((UnknownSpellCardException)s).getUnknownSpell()
						+ ")\nPlease enter a correct path: ");
			}
			in = sc.nextLine();
			try {
				this.spells = loadCardsFromFile(in);
			}
			catch (FileNotFoundException f2) {
				System.out.println("The file was not found.\nPlease enter a correct path for the spells database: "); //2
				in = sc.nextLine();
				try {
					this.spells = loadCardsFromFile(in);
				}
				catch (FileNotFoundException f3) {
					System.out.println("The file was not found.\nPlease enter a correct path for the spells database: ");
					in = sc.nextLine();
					try {
						this.spells = loadCardsFromFile(in);
					}
					catch (FileNotFoundException f5) {
						f5.printStackTrace();
						throw f5;
					}
					catch (UnexpectedFormatException f5) {
						f5.printStackTrace();
						throw f5;
					}
				}
				catch (UnexpectedFormatException m)
				{
					if (m instanceof MissingFieldException) {
						System.out.println("Line number " + m.getSourceLine() + " in file " + m.getSourceFile() 
								+ " is malformed.(Missing Field)\nPlease enter a correct path: ");
					}
					if (m instanceof EmptyFieldException) {
						System.out.println("Line number " + m.getSourceLine() + " in file " + m.getSourceFile() 
								+ " is malformed.(Field " + ((EmptyFieldException)m).getSourceField()
								+ " is empty)\nPlease enter a correct path: ");
					}
					if (m instanceof UnknownCardTypeException) {
						System.out.println("Line number " + m.getSourceLine() + " in file " + m.getSourceFile() 
								+ " is malformed.(Unknown Card Type: " + ((UnknownCardTypeException)m).getUnknownType()
								+ ")\nPlease enter a correct path: ");
					}
					if (m instanceof UnknownSpellCardException) {
						System.out.println("Line number " + m.getSourceLine() + " in file " + m.getSourceFile() 
								+ " is malformed.(Unknown Spell Card: " + ((UnknownSpellCardException)m).getUnknownSpell()
								+ ")\nPlease enter a correct path: ");
					}
					in = sc.nextLine();
					try {
						this.spells = loadCardsFromFile(in);
					}
					catch (FileNotFoundException f5) {
						f5.printStackTrace();
						throw f5;
					}
					catch (UnexpectedFormatException as) {
						as.printStackTrace();
						throw as;
					}
				}
			}
			catch (UnexpectedFormatException a) {
				if (a instanceof MissingFieldException) {
					System.out.println("Line number " + a.getSourceLine() + " in file " + a.getSourceFile() 
							+ " is malformed.(Missing Field)\nPlease enter a correct path: ");
				}
				if (a instanceof EmptyFieldException) {
					System.out.println("Line number " + a.getSourceLine() + " in file " + a.getSourceFile() 
							+ " is malformed.(Field " + ((EmptyFieldException)a).getSourceField()
							+ " is empty)\nPlease enter a correct path: ");
				}
				if (a instanceof UnknownCardTypeException) {
					System.out.println("Line number " + a.getSourceLine() + " in file " + a.getSourceFile() 
							+ " is malformed.(Unknown Card Type: " + ((UnknownCardTypeException)a).getUnknownType()
							+ ")\nPlease enter a correct path: ");
				}
				if (a instanceof UnknownSpellCardException) {
					System.out.println("Line number " + a.getSourceLine() + " in file " + a.getSourceFile() 
							+ " is malformed.(Unknown Spell Card: " + ((UnknownSpellCardException)a).getUnknownSpell()
							+ ")\nPlease enter a correct path: ");
				}
				in = sc.nextLine();
				try {
					this.spells = loadCardsFromFile(in);
				}
				catch (FileNotFoundException f3) {
					System.out.println("The file was not found.\nPlease enter a correct path for the spells database: ");
					in = sc.nextLine();
					try {
						this.spells = loadCardsFromFile(in);
					}
					catch (FileNotFoundException f5) {
						f5.printStackTrace();
						throw f5;
					}
					catch (UnexpectedFormatException as) {
						as.printStackTrace();
						throw as;
					}
				}
				catch (UnexpectedFormatException l) {
					if (l instanceof MissingFieldException) {
						System.out.println("Line number " + l.getSourceLine() + " in file " + l.getSourceFile() 
								+ " is malformed.(Missing Field)\nPlease enter a correct path: ");
					}
					if (l instanceof EmptyFieldException) {
						System.out.println("Line number " + l.getSourceLine() + " in file " + l.getSourceFile() 
								+ " is malformed.(Field " + ((EmptyFieldException)l).getSourceField()
								+ " is empty)\nPlease enter a correct path: ");
					}
					if (l instanceof UnknownCardTypeException) {
						System.out.println("Line number " + l.getSourceLine() + " in file " + l.getSourceFile() 
								+ " is malformed.(Unknown Card Type: " + ((UnknownCardTypeException)l).getUnknownType()
								+ ")\nPlease enter a correct path: ");
					}
					if (l instanceof UnknownSpellCardException) {
						System.out.println("Line number " + l.getSourceLine() + " in file " + l.getSourceFile() 
								+ " is malformed.(Unknown Spell Card: " + ((UnknownSpellCardException)l).getUnknownSpell()
								+ ")\nPlease enter a correct path: ");
					}
					in = sc.nextLine();
					try {
						this.spells = loadCardsFromFile(in);
					}
					catch (FileNotFoundException f5) {
						f5.printStackTrace();
						throw f5;
					}
					catch (UnexpectedFormatException as) {
						as.printStackTrace();
						throw as;
					}
				}
			}
		}
		buildDeck(monsters, spells);
		shuffleDeck();
	}

	@SuppressWarnings("resource")
	public ArrayList<Card> loadCardsFromFile(String path) throws IOException, UnexpectedFormatException{
		ArrayList<Card> s = new ArrayList<Card>();
		String currentLine = "";
		FileReader fileReader= new FileReader(path);
		BufferedReader br = new BufferedReader(fileReader);
		Scanner sc = new Scanner(System.in);
		int lineNum = 1;
		while ((currentLine = br.readLine()) != null) {
			String [] result= currentLine.split(",");
			for (int i = 0; i < result.length; i++) {
				if ((result[i].replaceAll("\\s+", "")).length() == 0)
				{
					throw new EmptyFieldException(path, lineNum, i+1);
				}
			}
			if(!(result[0].equals("Monster") || result[0].equals("Spell"))){
				throw new UnknownCardTypeException(path, lineNum, result[0]);
			}
			if(result[0].equals("Monster")){
				if (result.length < 6) {
					throw new MissingFieldException(path, lineNum);
				}
				s.add(new MonsterCard(result[1], result[2], Integer.parseInt(result[5]), Integer.parseInt(result[3]), Integer.parseInt(result[4])));
			}
			if(result[0].equals("Spell")){
				if (result.length < 3) {
					throw new MissingFieldException(path, lineNum);
				}
				switch(result[1]){
				case "Card Destruction":  s.add(new CardDestruction(result[1], result[2]));
				break;
				case "Change Of Heart":s.add(new ChangeOfHeart(result[1], result[2]));
				break;
				case "Dark Hole":  s.add(new DarkHole(result[1], result[2]));
				break;
				case "Graceful Dice":s.add(new GracefulDice(result[1], result[2]));
				break;
				case "Harpie's Feather Duster": s.add(new HarpieFeatherDuster(result[1], result[2]));
				break;
				case "Heavy Storm": s.add(new HeavyStorm(result[1], result[2]));
				break;
				case "Mage Power":  s.add(new MagePower(result[1], result[2]));
				break;
				case "Monster Reborn":  s.add(new MonsterReborn(result[1], result[2]));
				break;
				case "Pot of Greed":  s.add(new PotOfGreed(result[1], result[2]));
				break;
				case "Raigeki": s.add(new Raigeki(result[1], result[2]));
				break;
				default: throw new UnknownSpellCardException(path, lineNum, result[1]);
				}
			}
			lineNum++;
		}
		return s;

	}
	@SuppressWarnings({ "unchecked" })
	private void buildDeck(ArrayList<Card> monsters, ArrayList<Card> spells){

		ArrayList<Card> MonstersTMP = new ArrayList<Card>();
		if (monsters != null && spells != null) {
			for (Card c: monsters)
			{
				MonstersTMP.add(c);
			}
			Collections.shuffle(MonstersTMP);
			for(int i = 0; i< 15; i++){
				if(!MonstersTMP.isEmpty()){
					deck.add(MonstersTMP.get(0));
					MonstersTMP.remove(0);
				}
			}
			ArrayList<Card> SpellsTMP = new ArrayList<Card>();
			for (Card c: spells)
			{
				SpellsTMP.add(c);
			}

			Collections.shuffle(SpellsTMP);

			for(int i = 0; i< 5; i++){
				if(!SpellsTMP.isEmpty()){
					deck.add(SpellsTMP.get(0));
					SpellsTMP.remove(0);
				}
			}
		}
	}
	private void shuffleDeck (){
		Collections.shuffle(deck);
	}
	public ArrayList<Card> drawNCards(int n){
		ArrayList<Card> TheReturn = new ArrayList<Card>();
		System.out.println(this.getDeck().size());
		for(int i = 0;i<n && !deck.isEmpty();i++){
			TheReturn.add(this.drawOneCard());
		}


		return TheReturn;

	}
	public Card drawOneCard(){
		Card newCard = null;
		if (!deck.isEmpty()){
			newCard = deck.get(0);
			deck.remove(0);
		}
		return newCard;
	}

	public static ArrayList<Card> getMonsters() {
		return monsters;
	}

	public static void setMonsters(ArrayList<Card> monsters) {
		Deck.monsters = monsters;
	}

	public static ArrayList<Card> getSpells() {
		return spells;
	}

	public static void setSpells(ArrayList<Card> spells) {
		Deck.spells = spells;
	}

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}

	public static String getMonstersPath() {
		return monstersPath;
	}

	public static void setMonstersPath(String monstersPath) {
		Deck.monstersPath = monstersPath;
	}

	public static String getSpellsPath() {
		return spellsPath;
	}

	public static void setSpellsPath(String spellsPath) {
		Deck.spellsPath = spellsPath;
	}

}
