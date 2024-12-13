/* Sophia Chen
 * 12-10-24 P7
 * Punctuation.java
 * 
 * Pseudocode:
 * class definition for Punctuation
 * main method
 * 	declare a string variable text with the text passage
 *  call searchIt() and pass text to find punctuation words
 * searchIt method
 * 	call getPunctuationWords() to get words with punctuation
 * 	call printWord() to output the result
 * getPunctuationWords method
 * 	declare a variable start to track where the start of words
 *  declare a variable punctuationWords to store words that have punctuation
 *  loop through the text
 *   if the current character is a space, newline, or tab:
 *    get the substring from the start index to the current position i in the text
 *    if the word contains punctuation, add it to the punctuationWords
 *   return punctuationWords
 *  checkForPunctuation method
 *   loop through each character in the word
 *    if the character is punctuation, return true
 *   if no punctuation is found, return false
 * printWord method
 *  print all words with punctuation from punctuationWords
 * 
 * Output:
 * "
 * 
 * 
 * Words with punctuation: 
Blood,
Sweat,
13,
Mr.
Speaker:
Majesty's
Administration.
parties,
Opposition.
task.
Members,
representing,
Opposition,
nation.
serve,
office.
filled.
day,
events.
yesterday,
tonight.
tomorrow.
longer,
that,
again,
completed,
respects.
Sir,
today.
Mr.
steps,
House.
today,
Tuesday,
May,
with,
course,
meeting,
be.
opportunity.
House,
name,
Government.
Sir,
itself,
history,
Holland,
Mediterranean,
home.
today.
colleagues,
colleagues,
reconstruction,
act.
House,
who've
government:
"I
blood,
toil,
sweat."
kind.
many,
suffering.
ask,
policy?
say:
war,
sea,
air,
us;
tyranny,
crime.
policy.
ask,
aim?
word:
victory.
costs,
terror,
victory,
be;
victory,
survival.
realised;
Empire,
for,
ages,
goal.
hope.
men.
all,
say,
"Come
then,
strength."


"
 */

public class Punctuation
{
	// Main method to run the program
	public static void main(String[] args)
	{
		// Text from Winston Churchill's speech stored in the variable 'text'
		String text = "Blood, Sweat, and Tears by Winston Churchill " + "May 13, 1940 " + "Mr. Speaker: " + "On Friday evening last I received His Majesty's commission to form a new " + "Administration. It was the evident wish and will of Parliament and the nation that this should be conceived on the broadest possible basis and that it should include all parties, both those who supported the late Government and also the parties of the Opposition. " + 
		"I have completed the most important part of this task. A War Cabinet has been formed of five Members, representing, with the Liberal Opposition, the unity of the nation. The three party Leaders have agreed to serve, either in the War Cabinet or in high executive office. The three Fighting Services have been filled. It was necessary that this should be done in one single day, on account of the extreme urgency and rigour of events. A number of other key positions were filled yesterday, and I am submitting a further list to His Majesty tonight. I hope to complete the appointment of the principal Ministers during tomorrow. The appointment of the other Ministers usually takes a little longer, but I trust that, when Parliament meets again, this part of my task will be completed, and that the Administration will be complete in all respects. " + 
		"Sir, I considered it in the public interest to suggest that the House should be summoned to meet today. Mr. Speaker agreed and took the necessary steps, in accordance with the powers conferred upon him by the Resolution of the House. At the end of the proceedings today, the Adjournment of the House will be proposed until Tuesday, the 21st May, with, of course, provision for earlier meeting, if need be. The business to be considered during that week will be notified to Members at the earliest opportunity. I now invite the House, by the Resolution which stands in my name, to record its approval of the steps taken and to declare its confidence in the new Government. "  + 
		"Sir, to form an Administration of this scale and complexity is a serious undertaking in itself, but it must be remembered that we are in the preliminary stage of one of the greatest battles in history, that we are in action at many points in Norway and in Holland, that we have to be prepared in the Mediterranean, that the air battle is continuous and that many preparations have to be made here at home. In this crisis I hope I may be pardoned if I do not address the House at any length today. I hope that any of my friends and colleagues, or former colleagues, who are affected by the political reconstruction, will make all allowances for any lack of ceremony with which it has been necessary to act. I would say to the House, as I said to those who've joined this government: \"I have nothing to offer but blood, toil, tears and sweat.\" " + "We have before us an ordeal of the most grievous kind. We have before us many, many long months of struggle and of suffering. You ask, what is our policy? I will say: It is to wage war, by sea, land and air, with all our might and with all the strength that God can give us; to wage war against a monstrous tyranny, never surpassed in the dark and lamentable catalogue of human crime. That is our policy. You ask, what is our aim? I can answer in one word: victory. Victory at all costs, victory in spite of all terror, victory, however long and hard the road may be; for without victory, there is no survival. Let that be realised; no survival for the British Empire, no survival for all that the British Empire has stood for, no survival for the urge and impulse of the ages, that mankind will move forward towards its goal. " + 
		"But I take up my task with buoyancy and hope. I feel sure that our cause will not be suffered to fail among men. At this time I feel entitled to claim the aid of all, and I say, \"Come then, let us go forward together with our united strength.\"";
		
		Punctuation program = new Punctuation();
		// Call the searchIt() method to find punctuation words
		program.searchIt(text);
	}

	// This method is called from main, and finds and prints words with punctuation
	public void searchIt(String text)
	{
		// Call getPunctuationWords method, which extracts words that have punctuation
		String punctuationWords = getPunctuationWords(text);
		
		// Print words with punctuation
		printWord(punctuationWords);
	}

	// Method which scans text and finds words that have punctuation
	public String getPunctuationWords(String text)
	{
		// Variable to keep track of the starting index of each word
		int start = 0;
		
		// Initialize empty string that will stores words that have punctuation
		String punctuationWords = "";
		
		// Add a space to the end of the text to make sure the last word is detected
		text = text + " "; 

		// Loop through the entire text
		for (int i = 0; i < text.length(); i++)
		{
			char c = text.charAt(i); // Get each character in the text

			// If it's a space, newline, or tab, it's the end of a word
			if (c == ' ' || c == '\n' || c == '\t')
			{
				String word = text.substring(start, i); 

				// If the word has punctuation, add it to the punctuationWords string
				if (checkForPunctuation(word))
				{
					punctuationWords += word + "\n";
				}

				start = i + 1; // Move the start to the next word
			}
		}
		
		return punctuationWords; // Return all the words with punctuation
	}


	// This method checks if the word contains punctuation
	public boolean checkForPunctuation(String word)
	{
		// Loop through each character in the word
		for (int i = 0; i < word.length(); i++)
		{
			char c = word.charAt(i);
			
			// Check if the character is one of the punctuation marks
			if (",.!?:;\"'".indexOf(c) != -1)
			{
				return true; // Return true if punctuation mark is found
			}
		}
		
		return false; // Return false if no punctuation is found
	}

	// This method prints out the words with punctuation
	public void printWord(String word)
	{
		System.out.println("\n\n\n"); // Three new lines at start of output
		System.out.println("\nWords with punctuation: ");
		System.out.println(word); // Print all the words with punctuation
		System.out.println("\n\n\n"); // Three new lines to end output
	}
}
