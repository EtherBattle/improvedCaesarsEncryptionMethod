import java.util.Arrays;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;

public class improvedCaesarsEncryptionMethod {
	
	public static void main(String[] args) throws Exception {
		improvedCaesarsEncryptionMethod basis = new improvedCaesarsEncryptionMethod();
		while (true) {
			if (args.length==0) {
				System.out.println("Welcome to Caesar's Enchanced Encryption suite."+System.lineSeparator()+"Type help to get more info regarding the program.");
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Clipboard clipboard = toolkit.getSystemClipboard();
				String result = (String) clipboard.getData(DataFlavor.stringFlavor);
				Boolean answer = null;
				if (result.length()!=0) {
					System.out.println("It appears there is a string in your clipboard."+System.lineSeparator()+"Would you like to use that with one of our features?");
					while(true) {
						String[] tocheck = System.console().readLine().split(" ");
						for (String k : tocheck) {
							if (k.substring(0,1).toLowerCase().equals("y")) {
								answer = true;
								break;
							} else if (k.substring(0,1).toLowerCase().equals("n")) {
								answer = false;
								break;
							}
						}
						if (answer!=null)
							break;
						else
							System.out.println("I didn't quite get that. Please answer in any commonly accepted way.");
					}
				}
				if (answer==null)
					answer=false;
				if (answer) {
					System.out.println("Call the appropriate methods using the format supplied in the help doc.");
					String input = System.console().readLine().toLowerCase();
					if (input.indexOf("help")!=-1)
						basis.helpDocs();
					if (input.indexOf("-bf")!=-1) {
						if (input.indexOf("-ws")!=-1) {
							System.out.println("Write the position of each word seperated by a comma (,) (f.e. \"This is a tree\" the word is is the 2nd one so number 2)");
							String[] pos = System.console().readLine().split(",");
							int[] toSkip = new int[pos.length];
							boolean condition = true;
							while (condition) {
								for (int i = 0; i < toSkip.length; i++) {
									try {
										toSkip[i] = Integer.parseInt(pos[i]);
									} catch (NumberFormatException e) {
										System.out.println("Please make sure the numbers are only seperated by commas (,).");
										break;
									}
								}
								if (toSkip[toSkip.length-1]>0) {
									condition=false;
								} else {
									System.out.println("Write the position of each word seperated by a comma (,) (f.e. \"This is a tree\" the word is is the 2nd one so number 2)");
									pos = System.console().readLine().split(",");
								}
							}
							String decrypted = basis.decryptNormal(result,toSkip);
							System.out.println("Bruteforce was successful! Your decrypted sentence is:");
							System.out.println(decrypted);
							if (input.indexOf("-cb")!=-1) {
								System.out.println("Result copied to clipboard.");
								StringSelection selection = new StringSelection(decrypted);
								clipboard.setContents(selection,selection);
							}
						} else {
							String decrypted = basis.decryptNormal(result);
							System.out.println("Bruteforce was successful! Your decrypted sentence is:");
							System.out.println(decrypted);
							if (input.indexOf("-cb")!=-1) {
								System.out.println("Result copied to clipboard.");
								StringSelection selection = new StringSelection(decrypted);
								clipboard.setContents(selection,selection);
							}
						}
					} else if (input.indexOf("-d")!=-1) {
						if (input.indexOf("sce")!=-1) {
							if (input.indexOf("-p")!=-1) {
								int param = 0;
								for (int i = input.indexOf("-p")+1; i < input.length(); i++) {
									if (Character.isDigit(input.charAt(i))) {
										for (int j = i+1; j < input.length(); j++) {
											if (!Character.isDigit(input.charAt(j))) {
												param = Integer.parseInt(input.substring(i,j));
												break;
											}
										}
										break;
									}
								}
								if (param!=0) {
									if (input.indexOf("-ws")!=-1) {
										System.out.println("Write the position of each word seperated by a comma (,) (f.e. \"This is a tree\" the word is is the 2nd one so number 2)");
										String[] pos = System.console().readLine().split(",");
										int[] toSkip = new int[pos.length];
										boolean condition = true;
										while (condition) {
											for (int i = 0; i < toSkip.length; i++) {
												try {
													toSkip[i] = Integer.parseInt(pos[i]);
												} catch (NumberFormatException e) {
													System.out.println("Please make sure the numbers are only seperated by commas (,).");
													break;
												}
											}
											if (toSkip[toSkip.length-1]>0) {
												condition=false;
											} else {
												System.out.println("Write the position of each word seperated by a comma (,) (f.e. \"This is a tree\" the word is is the 2nd one so number 2)");
												pos = System.console().readLine().split(",");
											}
										}
										String decrypted = basis.decryptWhole(result,26-(param%26),toSkip);
										System.out.println("Your decrypted message is: ");
										System.out.println(decrypted);
										if (input.indexOf("-cb")!=-1) {
											System.out.println("Result copied to clipboard.");
											StringSelection selection = new StringSelection(decrypted);
											clipboard.setContents(selection,selection);
										}
									} else {
										String decrypted = basis.decryptWhole(result,26-(param%26));
										System.out.println("Your decrypted message is: ");
										System.out.println(decrypted);
										if (input.indexOf("-cb")!=-1) {
											System.out.println("Result copied to clipboard.");
											StringSelection selection = new StringSelection(decrypted);
											clipboard.setContents(selection,selection);
										}
									}
								} else {
									System.out.println("Invalid key parameter specified.");
								}
							} else {
								System.out.println("Please supply the key that was used to encrypt the message.");
								int param = 0;
								while (true) {
									try {
										param = Integer.parseInt(System.console().readLine());
										break;
									} catch (NumberFormatException e) {
										System.out.println("Please input the number used as a key during the encryption.");
									}
								}
								if (param!=0) {
									if (input.indexOf("-ws")!=-1) {
										System.out.println("Write the position of each word to be skipped seperated by a comma (,) (f.e. \"This is a tree\" the word is is the 2nd one so number 2)");
										String[] pos = System.console().readLine().split(",");
										int[] toSkip = new int[pos.length];
										boolean condition = true;
										while (condition) {
											for (int i = 0; i < toSkip.length; i++) {
												try {
													toSkip[i] = Integer.parseInt(pos[i]);
												} catch (NumberFormatException e) {
													System.out.println("Please make sure the numbers are only seperated by commas (,).");
													break;
												}
											}
											if (toSkip[toSkip.length-1]>0) {
												condition=false;
											} else {
												System.out.println("Write the position of each word to be skipped seperated by a comma (,) (f.e. \"This is a tree\" the word is is the 2nd one so number 2)");
												pos = System.console().readLine().split(",");
											}
										}
										String decrypted = basis.decryptWhole(result,26-(param%26),toSkip);
										System.out.println("Your decrypted message is: ");
										System.out.println(decrypted);
										if (input.indexOf("-cb")!=-1) {
											System.out.println("Result copied to clipboard.");
											StringSelection selection = new StringSelection(decrypted);
											clipboard.setContents(selection,selection);
										}
									} else {
										String decrypted = basis.decryptWhole(result,26-(param%26));
										System.out.println("Your decrypted message is: ");
										System.out.println(decrypted);
										if (input.indexOf("-cb")!=-1) {
											System.out.println("Result copied to clipboard.");
											StringSelection selection = new StringSelection(decrypted);
											clipboard.setContents(selection,selection);
										}
									}
								} else {
									System.out.println("Invalid key parameter specified.");
								}
							}
						} else if (input.indexOf("ece")!=-1) {
							if (input.indexOf("-p")!=-1) {
								String type = "";
								int position = 0;
								for (int i = input.indexOf("-p")+1; i < input.length(); i++) {
									if (Character.isDigit(input.charAt(i))) {
										type="a";
										position=i;
										break;
									} else if (input.charAt(i)=='(') {
										type="b";
										position=i;
										break;
									}
								}
								if (type.charAt(0) == 'a') {
									int param = 0;
									for (int i = position+1; i < input.length(); i++) {
										if (!Character.isDigit(input.charAt(i))) {
											param = Integer.parseInt(input.substring(position,i));
											break;
										}
										if (i==input.length()-1)
											param = Integer.parseInt(input.substring(position,input.length()));
									}
									if (position==input.length()-1)
										param = Integer.parseInt(input.substring(position,input.length()));
									if (param!=0) {
										String decrypted = basis.decryptEnchanced(result,param);
										System.out.println("Your decrypted message is: ");
										System.out.println(decrypted);
										if (input.indexOf("-cb")!=-1) {
											System.out.println("Result copied to clipboard.");
											StringSelection selection = new StringSelection(decrypted);
											clipboard.setContents(selection,selection);
										}
									} else {
										System.out.println("Invalid key parameter specified.");
									}
								} else {
									String decrypted = basis.decryptEnchanced(result,input.substring(position,input.lastIndexOf(")")+1));
									System.out.println("Your decrypted message is: ");
									System.out.println(decrypted);
									if (input.indexOf("-cb")!=-1) {
										System.out.println("Result copied to clipboard.");
										StringSelection selection = new StringSelection(decrypted);
										clipboard.setContents(selection,selection);
									}
								}
							} else {
								System.out.println("Please supply the appropriate key that was used to encrypt the message. Ensure it is valid.");
								String supplied = System.console().readLine();
								String type = "";
								for (int i = 0; i < supplied.length(); i++) {
									if (Character.isDigit(supplied.charAt(i))) {
										type="a";
										break;
									} else if (supplied.charAt(i)=='(') {
										type="b";
										break;
									}
								}
								if (type.charAt(0) == 'a') {
									int param;
									try {
										param = Integer.parseInt(supplied);
									} catch (NumberFormatException e) {
										param = 0;
									}
									if (param!=0) {
										String decrypted = basis.decryptEnchanced(result,param);
										System.out.println("Your decrypted message is: ");
										System.out.println(decrypted);
										if (input.indexOf("-cb")!=-1) {
											System.out.println("Result copied to clipboard.");
											StringSelection selection = new StringSelection(decrypted);
											clipboard.setContents(selection,selection);
										}
									} else {
										System.out.println("Invalid key parameter specified.");
									}
								} else {
									String decrypted = basis.decryptEnchanced(result,supplied);
									System.out.println("Your decrypted message is: ");
									System.out.println(decrypted);
									if (input.indexOf("-cb")!=-1) {
										System.out.println("Result copied to clipboard.");
										StringSelection selection = new StringSelection(decrypted);
										clipboard.setContents(selection,selection);
									}
								}
							}
						}
					} else if (input.indexOf("-e")!=-1) {
						if (input.indexOf("sce")!=-1) {
							if (input.indexOf("-p")!=-1) {
								int param = 0;
								for (int i = input.indexOf("-p")+1; i < input.length(); i++) {
									if (Character.isDigit(input.charAt(i))) {
										for (int j = i+1; j < input.length(); j++) {
											if (!Character.isDigit(input.charAt(j))) {
												param = Integer.parseInt(input.substring(i,j));
												break;
											}
											if (j == input.length()-1) {
												param = Integer.parseInt(input.substring(i,input.length()));
												break;
											}
										}
										if (i == input.length()-1)
											param = Integer.parseInt(input.substring(i,input.length()));
										break;
									}
								}
								if (param!=0) {
									if (input.indexOf("-ws")!=-1) {
										System.out.println("Write the position of each word to be skipped seperated by a comma (,) (f.e. \"This is a tree\" the word is is the 2nd one so number 2)");
										String[] pos = System.console().readLine().split(",");
										int[] toSkip = new int[pos.length];
										boolean condition = true;
										while (condition) {
											for (int i = 0; i < toSkip.length; i++) {
												try {
													toSkip[i] = Integer.parseInt(pos[i]);
												} catch (NumberFormatException e) {
													System.out.println("Please make sure the numbers are only seperated by commas (,).");
													break;
												}
											}
											if (toSkip[toSkip.length-1]>0) {
												condition=false;
											} else {
												System.out.println("Write the position of each word to be skipped seperated by a comma (,) (f.e. \"This is a tree\" the word is is the 2nd one so number 2)");
												pos = System.console().readLine().split(",");
											}
										}
										String encrypted = basis.encryptNormal(result,param,toSkip);
										System.out.println("Your encrypted message is: ");
										System.out.println(encrypted);
										if (input.indexOf("-cb")!=-1) {
											System.out.println("Result copied to clipboard.");
											StringSelection selection = new StringSelection(encrypted);
											clipboard.setContents(selection,selection);
										}
									} else {
										String encrypted = basis.encryptNormal(result,param);
										System.out.println("Your decrypted message is: ");
										System.out.println(encrypted);
										if (input.indexOf("-cb")!=-1) {
											System.out.println("Result copied to clipboard.");
											StringSelection selection = new StringSelection(encrypted);
											clipboard.setContents(selection,selection);
										}
									}
								} else {
									System.out.println("Invalid key parameter specified.");
								}
							} else {
								System.out.println("Please supply the key that was used to encrypt the message.");
								int param = 0;
								while (true) {
									try {
										param = Integer.parseInt(System.console().readLine());
										break;
									} catch (NumberFormatException e) {
										System.out.println("Please input the number used as a key during the encryption.");
									}
								}
								if (param!=0) {
									if (input.indexOf("-ws")!=-1) {
										System.out.println("Write the position of each word seperated by a comma (,) (f.e. \"This is a tree\" the word is is the 2nd one so number 2)");
										String[] pos = System.console().readLine().split(",");
										int[] toSkip = new int[pos.length];
										boolean condition = true;
										while (condition) {
											for (int i = 0; i < toSkip.length; i++) {
												try {
													toSkip[i] = Integer.parseInt(pos[i]);
												} catch (NumberFormatException e) {
													System.out.println("Please make sure the numbers are only seperated by commas (,).");
													break;
												}
											}
											if (toSkip[toSkip.length-1]>0) {
												condition=false;
											} else {
												System.out.println("Write the position of each word seperated by a comma (,) (f.e. \"This is a tree\" the word is is the 2nd one so number 2)");
												pos = System.console().readLine().split(",");
											}
										}
										String encrypted = basis.decryptWhole(result,26-(param%26),toSkip);
										System.out.println("Your encrypted message is: ");
										System.out.println(encrypted);
										if (input.indexOf("-cb")!=-1) {
											System.out.println("Result copied to clipboard.");
											StringSelection selection = new StringSelection(encrypted);
											clipboard.setContents(selection,selection);
										}
									} else {
										String encrypted = basis.decryptWhole(result,26-(param%26));
										System.out.println("Your encrypted message is: ");
										System.out.println(encrypted);
										if (input.indexOf("-cb")!=-1) {
											System.out.println("Result copied to clipboard.");
											StringSelection selection = new StringSelection(encrypted);
											clipboard.setContents(selection,selection);
										}
									}
								} else {
									System.out.println("Invalid key parameter specified.");
								}
							}
						} else if (input.indexOf("ece")!=-1) {
							if (input.indexOf("-p")!=-1) {
								String type = "";
								int position = 0;
								for (int i = input.indexOf("-p")+1; i < input.length(); i++) {
									if (Character.isDigit(input.charAt(i))) {
										type="a";
										position=i;
										break;
									} else if (input.charAt(i)=='(') {
										type="b";
										position=i;
										break;
									}
								}
								if (type.charAt(0) == 'a') {
									int param = 0;
									for (int i = position+1; i < input.length(); i++) {
										if (!Character.isDigit(input.charAt(i))) {
											param = Integer.parseInt(input.substring(position,i));
											break;
										}
										if (i == input.length()-1)
											param = Integer.parseInt(input.substring(position,input.length()));
									}
									if (position==input.length()-1)
										param = Integer.parseInt(input.substring(position,input.length()));
									if (param!=0) {
										String encrypted = basis.encryptEnchanced(result,param);
										System.out.println("Your encrypted message is: ");
										System.out.println(encrypted);
										if (input.indexOf("-cb")!=-1) {
											System.out.println("Result copied to clipboard.");
											StringSelection selection = new StringSelection(encrypted);
											clipboard.setContents(selection,selection);
										}
									} else {
										System.out.println("Invalid key parameter specified.");
									}
								} else {
									String encrypted = basis.encryptEnchanced(result,input.substring(position,input.lastIndexOf(")")+1));
									System.out.println("Your encrypted message is: ");
									System.out.println(encrypted);
									if (input.indexOf("-cb")!=-1) {
										System.out.println("Result copied to clipboard.");
										StringSelection selection = new StringSelection(encrypted);
										clipboard.setContents(selection,selection);
									}
								}
							} else {
								System.out.println("Please supply the appropriate key to be used during encryption. Ensure it is valid.");
								String supplied = System.console().readLine();
								String type = "";
								for (int i = 0; i < supplied.length(); i++) {
									if (Character.isDigit(supplied.charAt(i))) {
										type="a";
										break;
									} else if (supplied.charAt(i)=='(') {
										type="b";
										break;
									}
								}
								if (type.charAt(0) == 'a') {
									int param;
									try {
										param = Integer.parseInt(supplied);
									} catch (NumberFormatException e) {
										param = 0;
									}
									if (param!=0) {
										String encrypted = basis.encryptEnchanced(result,param);
										System.out.println("Your encrypted message is: ");
										System.out.println(encrypted);
										if (input.indexOf("-cb")!=-1) {
											System.out.println("Result copied to clipboard.");
											StringSelection selection = new StringSelection(encrypted);
											clipboard.setContents(selection,selection);
										}
									} else {
										System.out.println("Invalid key parameter specified.");
									}
								} else {
									String encrypted = basis.encryptEnchanced(result,supplied);
									System.out.println("Your encrypted message is: ");
									System.out.println(encrypted);
									if (input.indexOf("-cb")!=-1) {
										System.out.println("Result copied to clipboard.");
										StringSelection selection = new StringSelection(encrypted);
										clipboard.setContents(selection,selection);
									}
								}
							}
						}
					}
				} else {
					System.out.println("Call the appropriate methods using the format supplied in the help doc.");
					String input = System.console().readLine().toLowerCase();
					if (input.indexOf("help")!=-1)
						basis.helpDocs();
					if (input.indexOf("-bf")!=-1) {
						if (input.indexOf("-ws")!=-1) {
							System.out.println("Write the position of each word seperated by a comma (,) (f.e. \"This is a tree\" the word is is the 2nd one so number 2)");
							String[] pos = System.console().readLine().split(",");
							int[] toSkip = new int[pos.length];
							boolean condition = true;
							while (condition) {
								for (int i = 0; i < toSkip.length; i++) {
									try {
										toSkip[i] = Integer.parseInt(pos[i]);
									} catch (NumberFormatException e) {
										System.out.println("Please make sure the numbers are only seperated by commas (,).");
										break;
									}
								}
								if (toSkip[toSkip.length-1]>0) {
									condition=false;
								} else {
									System.out.println("Write the position of each word seperated by a comma (,) (f.e. \"This is a tree\" the word is is the 2nd one so number 2)");
									pos = System.console().readLine().split(",");
								}
							}
							System.out.println("Write or paste the complete sentence you want to bruteforce.");
							String decrypted = basis.decryptNormal(System.console().readLine(),toSkip);
							System.out.println("Bruteforce was successful! Your decrypted sentence is:");
							System.out.println(decrypted);
							if (input.indexOf("-cb")!=-1) {
								System.out.println("Result copied to clipboard.");
								StringSelection selection = new StringSelection(decrypted);
								clipboard.setContents(selection,selection);
							}
						} else {
							System.out.println("Write or paste the complete sentence you want to bruteforce.");
							String decrypted = basis.decryptNormal(System.console().readLine());
							System.out.println("Bruteforce was successful! Your decrypted sentence is:");
							System.out.println(decrypted);
							if (input.indexOf("-cb")!=-1) {
								System.out.println("Result copied to clipboard.");
								StringSelection selection = new StringSelection(decrypted);
								clipboard.setContents(selection,selection);
							}
						}
					} else if (input.indexOf("-d")!=-1) {
						if (input.indexOf("sce")!=-1) {
							if (input.indexOf("-p")!=-1) {
								int param = 0;
								for (int i = input.indexOf("-p")+1; i < input.length(); i++) {
									if (Character.isDigit(input.charAt(i))) {
										for (int j = i+1; j < input.length(); j++) {
											if (!Character.isDigit(input.charAt(j))) {
												param = Integer.parseInt(input.substring(i,j));
												break;
											}
											if (j == input.length()-1) {
												param = Integer.parseInt(input.substring(i,input.length()));
												break;
											}
										}
										if (i == input.length()-1)
											param = Integer.parseInt(input.substring(i,input.length()));
									}
								}
								if (param!=0) {
									if (input.indexOf("-ws")!=-1) {
										System.out.println("Write the position of each word seperated by a comma (,) (f.e. \"This is a tree\" the word is is the 2nd one so number 2)");
										String[] pos = System.console().readLine().split(",");
										int[] toSkip = new int[pos.length];
										boolean condition = true;
										while (condition) {
											for (int i = 0; i < toSkip.length; i++) {
												try {
													toSkip[i] = Integer.parseInt(pos[i]);
												} catch (NumberFormatException e) {
													System.out.println("Please make sure the numbers are only seperated by commas (,).");
													break;
												}
											}
											if (toSkip[toSkip.length-1]>0) {
												condition=false;
											} else {
												System.out.println("Write the position of each word seperated by a comma (,) (f.e. \"This is a tree\" the word is is the 2nd one so number 2)");
												pos = System.console().readLine().split(",");
											}
										}
										System.out.println("Write or paste the complete sentence you want to decrypt.");
										String decrypted = basis.decryptWhole(System.console().readLine(),26-(param%26),toSkip);
										System.out.println("Your decrypted message is: ");
										System.out.println(decrypted);
										if (input.indexOf("-cb")!=-1) {
											System.out.println("Result copied to clipboard.");
											StringSelection selection = new StringSelection(decrypted);
											clipboard.setContents(selection,selection);
										}
									} else {
										System.out.println("Write or paste the complete sentence you want to decrypt.");
										String decrypted = basis.decryptWhole(System.console().readLine(),26-(param%26));
										System.out.println("Your decrypted message is: ");
										System.out.println(decrypted);
										if (input.indexOf("-cb")!=-1) {
											System.out.println("Result copied to clipboard.");
											StringSelection selection = new StringSelection(decrypted);
											clipboard.setContents(selection,selection);
										}
									}
								} else {
									System.out.println("Invalid key parameter specified.");
								}
							} else {
								System.out.println("Please supply the key that was used to encrypt the message.");
								int param = 0;
								while (true) {
									try {
										param = Integer.parseInt(System.console().readLine());
										break;
									} catch (NumberFormatException e) {
										System.out.println("Please input the number used as a key during the encryption.");
									}
								}
								if (param!=0) {
									if (input.indexOf("-ws")!=-1) {
										System.out.println("Write the position of each word to be skipped seperated by a comma (,) (f.e. \"This is a tree\" the word is is the 2nd one so number 2)");
										String[] pos = System.console().readLine().split(",");
										int[] toSkip = new int[pos.length];
										boolean condition = true;
										while (condition) {
											for (int i = 0; i < toSkip.length; i++) {
												try {
													toSkip[i] = Integer.parseInt(pos[i]);
												} catch (NumberFormatException e) {
													System.out.println("Please make sure the numbers are only seperated by commas (,).");
													break;
												}
											}
											if (toSkip[toSkip.length-1]>0) {
												condition=false;
											} else {
												System.out.println("Write the position of each word to be skipped seperated by a comma (,) (f.e. \"This is a tree\" the word is is the 2nd one so number 2)");
												pos = System.console().readLine().split(",");
											}
										}
										System.out.println("Write or paste the complete sentence you want to decrypt.");
										String decrypted = basis.decryptWhole(System.console().readLine(),26-(param%26),toSkip);
										System.out.println("Your decrypted message is: ");
										System.out.println(decrypted);
										if (input.indexOf("-cb")!=-1) {
											System.out.println("Result copied to clipboard.");
											StringSelection selection = new StringSelection(decrypted);
											clipboard.setContents(selection,selection);
										}
									} else {
										System.out.println("Write or paste the complete sentence you want to decrypt.");
										String decrypted = basis.decryptWhole(System.console().readLine(),26-(param%26));
										System.out.println("Your decrypted message is: ");
										System.out.println(decrypted);
										if (input.indexOf("-cb")!=-1) {
											System.out.println("Result copied to clipboard.");
											StringSelection selection = new StringSelection(decrypted);
											clipboard.setContents(selection,selection);
										}
									}
								} else {
									System.out.println("Invalid key parameter specified.");
								}
							}
						} else if (input.indexOf("ece")!=-1) {
							if (input.indexOf("-p")!=-1) {
								String type = "";
								int position = 0;
								for (int i = input.indexOf("-p")+1; i < input.length(); i++) {
									if (Character.isDigit(input.charAt(i))) {
										type="a";
										position=i;
										break;
									} else if (input.charAt(i)=='(') {
										type="b";
										position=i;
										break;
									}
								}
								if (type.charAt(0) == 'a') {
									int param = 0;
									for (int i = position+1; i < input.length(); i++) {
										if (!Character.isDigit(input.charAt(i))) {
											param = Integer.parseInt(input.substring(position,i));
											break;
										}
										if (i == input.length()-1) {
											param = Integer.parseInt(input.substring(position,input.length()-1));
										}
									}
									if (position == input.length()-1)
										param = Integer.parseInt(input.substring(position,input.length()-1));
									if (param!=0) {
										System.out.println("Write or paste the complete sentence you want to decrypt.");
										String decrypted = basis.decryptEnchanced(System.console().readLine(),param);
										System.out.println("Your decrypted message is: ");
										System.out.println(decrypted);
										if (input.indexOf("-cb")!=-1) {
											System.out.println("Result copied to clipboard.");
											StringSelection selection = new StringSelection(decrypted);
											clipboard.setContents(selection,selection);
										}
									} else {
										System.out.println("Invalid key parameter specified.");
									}
								} else {
									System.out.println("Write or paste the complete sentence you want to decrypt.");
									String decrypted = basis.decryptEnchanced(System.console().readLine(),input.substring(position,input.lastIndexOf(")")+1));
									System.out.println("Your decrypted message is: ");
									System.out.println(decrypted);
									if (input.indexOf("-cb")!=-1) {
										System.out.println("Result copied to clipboard.");
										StringSelection selection = new StringSelection(decrypted);
										clipboard.setContents(selection,selection);
									}
								}
							} else {
								System.out.println("Please supply the appropriate key that was used to encrypt the message. Ensure it is valid.");
								String supplied = System.console().readLine();
								String type = "";
								for (int i = 0; i < supplied.length(); i++) {
									if (Character.isDigit(supplied.charAt(i))) {
										type="a";
										break;
									} else if (supplied.charAt(i)=='(') {
										type="b";
										break;
									}
								}
								if (type.charAt(0) == 'a') {
									int param;
									try {
										param = Integer.parseInt(supplied);
									} catch (NumberFormatException e) {
										param = 0;
									}
									if (param!=0) {
										System.out.println("Write or paste the complete sentence you want to decrypt.");
										String decrypted = basis.decryptEnchanced(System.console().readLine(),param);
										System.out.println("Your decrypted message is: ");
										System.out.println(decrypted);
										if (input.indexOf("-cb")!=-1) {
											System.out.println("Result copied to clipboard.");
											StringSelection selection = new StringSelection(decrypted);
											clipboard.setContents(selection,selection);
										}
									} else {
										System.out.println("Invalid key parameter specified.");
									}
								} else {
									System.out.println("Write or paste the complete sentence you want to decrypt.");
									String decrypted = basis.decryptEnchanced(System.console().readLine(),supplied);
									System.out.println("Your decrypted message is: ");
									System.out.println(decrypted);
									if (input.indexOf("-cb")!=-1) {
										System.out.println("Result copied to clipboard.");
										StringSelection selection = new StringSelection(decrypted);
										clipboard.setContents(selection,selection);
									}
								}
							}
						}
					} else if (input.indexOf("-e")!=-1) {
						if (input.indexOf("sce")!=-1) {
							if (input.indexOf("-p")!=-1) {
								int param = 0;
								for (int i = input.indexOf("-p")+1; i < input.length(); i++) {
									if (Character.isDigit(input.charAt(i))) {
										for (int j = i+1; j < input.length(); j++) {
											if (!Character.isDigit(input.charAt(j))) {
												param = Integer.parseInt(input.substring(i,j));
												break;
											}
											if (j == input.length()-1) {
												param = Integer.parseInt(input.substring(i,input.length()));
											}
										}
										if (i==input.length()-1)
											param = Integer.parseInt(input.substring(i,input.length()));
										break;
									}
								}
								if (param!=0) {
									if (input.indexOf("-ws")!=-1) {
										System.out.println("Write the position of each word to be skipped seperated by a comma (,) (f.e. \"This is a tree\" the word is is the 2nd one so number 2)");
										String[] pos = System.console().readLine().split(",");
										int[] toSkip = new int[pos.length];
										boolean condition = true;
										while (condition) {
											for (int i = 0; i < toSkip.length; i++) {
												try {
													toSkip[i] = Integer.parseInt(pos[i]);
												} catch (NumberFormatException e) {
													System.out.println("Please make sure the numbers are only seperated by commas (,).");
													break;
												}
											}
											if (toSkip[toSkip.length-1]>0) {
												condition=false;
											} else {
												System.out.println("Write the position of each word to be skipped seperated by a comma (,) (f.e. \"This is a tree\" the word is is the 2nd one so number 2)");
												pos = System.console().readLine().split(",");
											}
										}
										System.out.println("Write or paste the complete sentence you want to encrypt.");
										String encrypted = basis.encryptNormal(System.console().readLine(),param,toSkip);
										System.out.println("Your encrypted message is: ");
										System.out.println(encrypted);
										if (input.indexOf("-cb")!=-1) {
											System.out.println("Result copied to clipboard.");
											StringSelection selection = new StringSelection(encrypted);
											clipboard.setContents(selection,selection);
										}
									} else {
										System.out.println("Write or paste the complete sentence you want to encrypt.");
										String encrypted = basis.encryptNormal(System.console().readLine(),param);
										System.out.println("Your decrypted message is: ");
										System.out.println(encrypted);
										if (input.indexOf("-cb")!=-1) {
											System.out.println("Result copied to clipboard.");
											StringSelection selection = new StringSelection(encrypted);
											clipboard.setContents(selection,selection);
										}
									}
								} else {
									System.out.println("Invalid key parameter specified.");
								}
							} else {
								System.out.println("Please supply the key that was used to encrypt the message.");
								int param = 0;
								while (true) {
									try {
										param = Integer.parseInt(System.console().readLine());
										break;
									} catch (NumberFormatException e) {
										System.out.println("Please input the number used as a key during the encryption.");
									}
								}
								if (param!=0) {
									if (input.indexOf("-ws")!=-1) {
										System.out.println("Write the position of each word seperated by a comma (,) (f.e. \"This is a tree\" the word is is the 2nd one so number 2)");
										String[] pos = System.console().readLine().split(",");
										int[] toSkip = new int[pos.length];
										boolean condition = true;
										while (condition) {
											for (int i = 0; i < toSkip.length; i++) {
												try {
													toSkip[i] = Integer.parseInt(pos[i]);
												} catch (NumberFormatException e) {
													System.out.println("Please make sure the numbers are only seperated by commas (,).");
													break;
												}
											}
											if (toSkip[toSkip.length-1]>0) {
												condition=false;
											} else {
												System.out.println("Write the position of each word seperated by a comma (,) (f.e. \"This is a tree\" the word is is the 2nd one so number 2)");
												pos = System.console().readLine().split(",");
											}
										}
										System.out.println("Write or paste the complete sentence you want to encrypt.");
										String encrypted = basis.decryptWhole(System.console().readLine(),26-(param%26),toSkip);
										System.out.println("Your encrypted message is: ");
										System.out.println(encrypted);
										if (input.indexOf("-cb")!=-1) {
											System.out.println("Result copied to clipboard.");
											StringSelection selection = new StringSelection(encrypted);
											clipboard.setContents(selection,selection);
										}
									} else {
										System.out.println("Write or paste the complete sentence you want to encrypt.");
										String encrypted = basis.decryptWhole(System.console().readLine(),26-(param%26));
										System.out.println("Your encrypted message is: ");
										System.out.println(encrypted);
										if (input.indexOf("-cb")!=-1) {
											System.out.println("Result copied to clipboard.");
											StringSelection selection = new StringSelection(encrypted);
											clipboard.setContents(selection,selection);
										}
									}
								} else {
									System.out.println("Invalid key parameter specified.");
								}
							}
						} else if (input.indexOf("ece")!=-1) {
							if (input.indexOf("-p")!=-1) {
								String type = "";
								int position = 0;
								for (int i = input.indexOf("-p")+1; i < input.length(); i++) {
									if (Character.isDigit(input.charAt(i))) {
										type="a";
										position=i;
										break;
									} else if (input.charAt(i)=='(') {
										type="b";
										position=i;
										break;
									}
								}
								if (type.charAt(0) == 'a') {
									int param = 0;
									for (int i = position+1; i < input.length(); i++) {
										if (!Character.isDigit(input.charAt(i))) {
											param = Integer.parseInt(input.substring(position,i));
											break;
										}
										if (i==input.length())
											param = Integer.parseInt(input.substring(position,input.length()));
									}
									if (position==input.length()-1)
										param = Integer.parseInt(input.substring(position,input.length()));
									if (param!=0) {
										System.out.println("Write or paste the complete sentence you want to encrypt.");
										String encrypted = basis.encryptEnchanced(System.console().readLine(),param);
										System.out.println("Your encrypted message is: ");
										System.out.println(encrypted);
										if (input.indexOf("-cb")!=-1) {
											System.out.println("Result copied to clipboard.");
											StringSelection selection = new StringSelection(encrypted);
											clipboard.setContents(selection,selection);
										}
									} else {
										System.out.println("Invalid key parameter specified.");
									}
								} else {
									System.out.println("Write or paste the complete sentence you want to encrypt.");
									String encrypted = basis.encryptEnchanced(System.console().readLine(),input.substring(position,input.lastIndexOf(")")+1));
									System.out.println("Your encrypted message is: ");
									System.out.println(encrypted);
									if (input.indexOf("-cb")!=-1) {
										System.out.println("Result copied to clipboard.");
										StringSelection selection = new StringSelection(encrypted);
										clipboard.setContents(selection,selection);
									}
								}
							} else {
								System.out.println("Please supply the appropriate key to be used during encryption. Ensure it is valid.");
								String supplied = System.console().readLine();
								String type = "";
								for (int i = 0; i < supplied.length(); i++) {
									if (Character.isDigit(supplied.charAt(i))) {
										type="a";
										break;
									} else if (supplied.charAt(i)=='(') {
										type="b";
										break;
									}
								}
								if (type.charAt(0) == 'a') {
									int param;
									try {
										param = Integer.parseInt(supplied);
									} catch (NumberFormatException e) {
										param = 0;
									}
									if (param!=0) {
										System.out.println("Write or paste the complete sentence you want to encrypt.");
										String encrypted = basis.encryptEnchanced(System.console().readLine(),param);
										System.out.println("Your encrypted message is: ");
										System.out.println(encrypted);
										if (input.indexOf("-cb")!=-1) {
											System.out.println("Result copied to clipboard.");
											StringSelection selection = new StringSelection(encrypted);
											clipboard.setContents(selection,selection);
										}
									} else {
										System.out.println("Invalid key parameter specified.");
									}
								} else {
									System.out.println("Write or paste the complete sentence you want to encrypt.");
									String encrypted = basis.encryptEnchanced(System.console().readLine(),supplied);
									System.out.println("Your encrypted message is: ");
									System.out.println(encrypted);
									if (input.indexOf("-cb")!=-1) {
										System.out.println("Result copied to clipboard.");
										StringSelection selection = new StringSelection(encrypted);
										clipboard.setContents(selection,selection);
									}
								}
							}
						}
					}
				}
				System.out.println("Would you like to continue?");
				answer = null;
				while(true) {
					String[] tocheck = System.console().readLine().split(" ");
					for (String k : tocheck) {
						if (k.substring(0,1).toLowerCase().equals("y")) {
							answer = true;
							break;
						} else if (k.substring(0,1).toLowerCase().equals("n")) {
							answer = false;
							break;
						}
					}
					if (answer!=null)
						break;
					else
						System.out.println("I didn't quite get that. Please answer in any commonly accepted way.");
				}
				if (!answer)
					break;
			}
		}
	}
	
	private char[] alphabetdb = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private String[] bruteforceWords2 = "to on in of at an am if as go it is".split(" ");
	private String[] bruteforceWords3 = "the and for are not but you all any can was one our out get day how has new now old too use".split(" ");
	private String[] bruteforceWords1 = "a i".split(" ");
	
	public String encryptNormal(String toE, int deviation) {
		char[] toEncrypt = toE.toCharArray();
		for (int i = 0; i < toEncrypt.length; i++) {
			if (!Character.isLetter(toEncrypt[i]))
				continue;
			for (int j = 0; j < alphabetdb.length; j++) {
				if (toEncrypt[i]==alphabetdb[j] && alphabetdb[j]==Character.toUpperCase(alphabetdb[j])){
					toEncrypt[i]=alphabetdb[(j+deviation)%26+26];
					break;
				} else if (toEncrypt[i]==alphabetdb[j]) {
					toEncrypt[i]=alphabetdb[(j+deviation)%26];
					break;
				}
			}
		}
		return (new String(toEncrypt));
	}
	
	public String encryptNormal(String toE, int deviation,int[] skipWords) {
		char[] toEncrypt = toE.toCharArray();
		int currword = 1;
		int curri = 0;
		for (int i = 0; i < toEncrypt.length; i++) {
			if (Character.isWhitespace(toEncrypt[i]) && currword==skipWords[curri>=skipWords.length?0:curri]) {
				curri++;
				currword++;
				continue;
			} else if (Character.isWhitespace(toEncrypt[i])) {
				currword++;
				continue;
			} else if (currword==skipWords[curri>=skipWords.length?0:curri] || !Character.isLetter(toEncrypt[i]))
				continue;
			for (int j = 0; j < alphabetdb.length; j++) {
				if (toEncrypt[i]==alphabetdb[j] && alphabetdb[j]==Character.toUpperCase(alphabetdb[j])){
					toEncrypt[i]=alphabetdb[(j+deviation)%26+26];
					break;
				} else if (toEncrypt[i]==alphabetdb[j]) {
					toEncrypt[i]=alphabetdb[(j+deviation)%26];
					break;
				}
			}
		}
		return (new String(toEncrypt));
	}

	public String decryptNormal(String toDecrypt) {
		String[] bruteforce = toDecrypt.split(" ");
		System.out.println("Attempting reliable decryption...");
		for (int i = 0; i < bruteforce.length; i++) {
			if (bruteforce[i].length() == 2 || bruteforce[i].length() == 3) {
				int matched = reliableDecryption(bruteforce[i]);
				if (matched != -1) {
					String decrypted = decryptWhole(toDecrypt, matched);
					System.out.println(decrypted);
					System.out.println("Does the above sentence make sense?");
					Boolean answer = null;
					while(true) {
						String[] tocheck = System.console().readLine().split(" ");
						for (String k : tocheck) {
							if (k.substring(0,1).equals("y")) {
								answer = true;
								break;
							} else if (k.substring(0,1).equals("n")) {
								answer = false;
								break;
							}
						}
						if (answer!=null)
							break;
						else
							System.out.println("I didn't quite get that. Please answer in any commonly accepted way.");
					}
					if (answer) {
						return decrypted;
					}
				} else {
					System.out.println("Decryption attempt failed. Probable causes: Sequence of numbers or non-English words in sentence.");
				}
			}
		}
		System.out.println("No suitable candidates found. Attempting unreliable decryption.");
		for (int i = 0; i < bruteforce.length; i++) {
			if (bruteforce[i].length() == 1) {
				int matched = unreliableDecryption(bruteforce[i].charAt(0));
				if (matched != -1) {
					String decrypted = decryptWhole(toDecrypt, matched);
					System.out.println(decrypted);
					System.out.println("Does the above sentence make sense?");
					Boolean answer = null;
					while(true) {
						String[] tocheck = System.console().readLine().split(" ");
						for (String k : tocheck) {
							if (k.substring(0,1).equals("y")) {
								answer = true;
								break;
							} else if (k.substring(0,1).equals("n")) {
								answer = false;
								break;
							}
						}
						if (answer!=null)
							break;
						else
							System.out.println("I didn't quite get that. Please answer in any commonly accepted way.");
					}
					if (answer) {
						return decrypted;
					}
				} else {
					System.out.println("Decryption attempt failed. Probable causes: Number or non-canonical letter use.");
				}
			}
		}
		System.out.println("No suitable candidates found. Unable to decrypt via bruteforce method...");
		return "";
	}
	
	public String decryptNormal(String toDecrypt, int[] skipWords) {
		String[] bruteforce = toDecrypt.split(" ");
		int curri = 0;
		System.out.println("Attempting reliable decryption...");
		for (int i = 0; i < bruteforce.length; i++) {
			if (i+1 == skipWords[curri>=skipWords.length?0:curri]) {
				curri++;
				continue;
			}	
			if (bruteforce[i].length() == 2 || bruteforce[i].length() == 3) {
				int matched = reliableDecryption(bruteforce[i]);
				if (matched != -1) {
					String decrypted = decryptWhole(toDecrypt,matched,skipWords);
					System.out.println(decrypted);
					System.out.println("Does the above sentence make sense?");
					Boolean answer = null;
					while(true) {
						String[] tocheck = System.console().readLine().split(" ");
						for (String k : tocheck) {
							if (k.substring(0,1).toLowerCase().equals("y")) {
								answer = true;
								break;
							} else if (k.substring(0,1).toLowerCase().equals("n")) {
								answer = false;
								break;
							}
						}
						if (answer!=null)
							break;
						else
							System.out.println("I didn't quite get that. Please answer in any commonly accepted way.");
					}
					if (answer) {
						return decrypted;
					}
				} else {
					System.out.println("Decryption attempt failed. Probable causes: Sequence of numbers or non-English words in sentence.");
				}
			}
		}
		System.out.println("No suitable candidates found. Attempting unreliable decryption.");
		curri = 0;
		for (int i = 0; i < bruteforce.length; i++) {
			if (i+1 == skipWords[curri>=skipWords.length?0:curri]) {
				curri++;
				continue;
			}
			if (bruteforce[i].length() == 1) {
				int matched = unreliableDecryption(bruteforce[i].charAt(0));
				if (matched != -1) {
					String decrypted = decryptWhole(toDecrypt, matched, skipWords);
					System.out.println(decrypted);
					System.out.println("Does the above sentence make sense?");
					Boolean answer = null;
					while(true) {
						String[] tocheck = System.console().readLine().split(" ");
						for (String k : tocheck) {
							if (k.substring(0,1).toLowerCase().equals("y")) {
								answer = true;
								break;
							} else if (k.substring(0,1).toLowerCase().equals("n")) {
								answer = false;
								break;
							}
						}
						if (answer!=null)
							break;
						else
							System.out.println("I didn't quite get that. Please answer in any commonly accepted way.");
					}
					if (answer) {
						return decrypted;
					}
				} else {
					System.out.println("Decryption attempt failed. Probable causes: Number or non-canonical letter use.");
				}
			}
		}
		System.out.println("No suitable candidates found. Unable to decrypt via bruteforce method...");
		return "";
	}
	
	public int reliableDecryption(String toDecrypt) {
		char[] inProgress = toDecrypt.toCharArray();
		String temp = "";
		for (int i = 1; i < 26; i++) {
			for (int j = 0; j < inProgress.length; j++) {
				temp += alphabetdb[("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(Character.toLowerCase(inProgress[j]))+i)%26];
			}
			if (temp.length() == 2)
				for (int j = 0; j < bruteforceWords2.length; j++) {
					if (bruteforceWords2[j].equals(temp))
						return i;
					else if (bruteforceWords2[j].equals(toDecrypt)) {
						System.out.println("Sentence appears to be partially encrypted. Results may be inaccurate.");
						break;
					}
				}
			else
				for (int j = 0; j < bruteforceWords3.length; j++) {
					if (bruteforceWords3[j].equals(temp))
						return i;
					else if (bruteforceWords3[j].equals(toDecrypt)) {
						System.out.println("Sentence appears to be partially encrypted. Results may be inaccurate.");
						break;
					}
				}
			temp = new String("");
		}
		return -1;
	}
	
	public int unreliableDecryption(char toDecrypt) {
		String temp = "";
		for (int i = 1; i < 26; i++) {
			temp += alphabetdb[("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(Character.toLowerCase(toDecrypt))+i)%26];
			for (int j = 0; j < bruteforceWords1.length; j++)
				if (bruteforceWords1[j].equals(temp))
					return i;
			temp = new String("");
		}
		return -1;
	}
	
	public String decryptWhole(String toDecrypt, int deviation) {
		String temp = "";
		for (int i = 0; i < toDecrypt.length(); i++) {
			int index = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(toDecrypt.charAt(i));
			temp += index==-1?" ":alphabetdb[(index+deviation)%26+(index>=26?26:0)];
		}
		return temp;
	}
	
	public String decryptWhole(String toDecrypt, int deviation, int[] skip) {
		String temp = "";
		int curri = 0;
		String[] words = toDecrypt.split(" ");
		for (int j = 0; j < words.length; j++) {
			if (j+1 == skip[curri>=skip.length?0:curri]) {
				curri++;
				continue;
			}
			String temp2 = "";
			for (int i = 0; i < words[j].length(); i++) {
				int index = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(words[j].charAt(i));
				temp2 += alphabetdb[(index+deviation)%26+(index>=26?26:0)];
			}
			words[j] = temp2;
		}
		temp = "";
		for (int i = 0; i < words.length; i++) {
			temp += words[i]+" ";
		}
		return temp.substring(0,temp.length()-1);
	}
	
	public String encryptEnchanced(String toE, int bipolarMultiplier) {
		char[] toEncrypt = toE.toCharArray();
		for (int i = 0; i < toEncrypt.length; i++) {
			if (!Character.isLetter(toEncrypt[i]))
				continue;
			for (int j = 0; j < alphabetdb.length; j++) {
				if (toEncrypt[i]==alphabetdb[j] && alphabetdb[j]==Character.toUpperCase(alphabetdb[j])){
					int x = (j+((i+1)*(i%2==0?(-1*bipolarMultiplier):bipolarMultiplier)));
					while (x<0)
						x+=26;
					toEncrypt[i]=alphabetdb[x%26];
					break;
				} else if (toEncrypt[i]==alphabetdb[j]) {
					int x = (j+((i+1)*(i%2==0?(-1*bipolarMultiplier):bipolarMultiplier)));
					while (x<0)
						x+=26;
					toEncrypt[i]=alphabetdb[x%26+26];
					break;
				}
			}
		}
		return (new String(toEncrypt));
	}
	
	public String encryptEnchanced(String toE, String function) {
		char[] toEncrypt = toE.toCharArray();
		for (int i = 0; i < toEncrypt.length; i++) {
			if (!Character.isLetter(toEncrypt[i]))
				continue;
			for (int j = 0; j < alphabetdb.length; j++) {
				if (toEncrypt[i]==alphabetdb[j] && alphabetdb[j]==Character.toUpperCase(alphabetdb[j])){
					toEncrypt[i]=alphabetdb[(j+(functionExecution(i+1,function)))%26];
					break;
				} else if (toEncrypt[i]==alphabetdb[j]) {
					toEncrypt[i]=alphabetdb[(j+(functionExecution(i+1,function)))%26+26];
					break;
				}
			}
		}
		return (new String(toEncrypt));
	}
	
	public String decryptEnchanced(String toD, int bipolarMultiplier) {
		char[] toDecrypt = toD.toCharArray();
		for (int i = 0; i < toDecrypt.length; i++) {
			if (!Character.isLetter(toDecrypt[i]))
				continue;
			for (int j = 0; j < alphabetdb.length; j++) {
				if (toDecrypt[i]==alphabetdb[j] && alphabetdb[j]==Character.toUpperCase(alphabetdb[j])){
					if (i%2!=0) {
						int x = j-bipolarMultiplier*(i+1);
						while (x<0)
							x+=26;
						toDecrypt[i]=Character.toLowerCase(alphabetdb[x%26]);
					} else {
						int x = j+bipolarMultiplier*(i+1);
						toDecrypt[i]=Character.toLowerCase(alphabetdb[x%26]);
					}
					break;
				} else if (toDecrypt[i]==alphabetdb[j]) {
					if (i%2!=0) {
						int x = j-bipolarMultiplier*(i+1);
						while (x<0)
							x+=26;
						toDecrypt[i]=Character.toUpperCase(alphabetdb[x+26]);
					} else {
						int x = j+bipolarMultiplier*(i+1);
						toDecrypt[i]=Character.toUpperCase(alphabetdb[x%26+26]);
					}
					break;
				}
			}
		}
		return (new String(toDecrypt));
	}
	
	public String decryptEnchanced(String toD, String function) {
		char[] toDecrypt = toD.toCharArray();
		for (int i = 0; i < toDecrypt.length; i++) {
			if (!Character.isLetter(toDecrypt[i]))
				continue;
			for (int j = 0; j < alphabetdb.length; j++) {
				if (toDecrypt[i]==alphabetdb[j] && alphabetdb[j]==Character.toUpperCase(alphabetdb[j])){
					int x = j-functionExecution(i+1,function);
					while (x<0)
						x+=26;
					toDecrypt[i]=alphabetdb[x%26];
					break;
				} else if (toDecrypt[i]==alphabetdb[j]) {
					int x = j-functionExecution(i+1,function);
					while (x<0)
						x+=26;
					toDecrypt[i]=alphabetdb[x%26+26];
					break;
				}
			}
		}
		return (new String(toDecrypt));
	}
	
	public int functionExecution(int x, String toExecute) {
		int value = 0;
		int st = toExecute.lastIndexOf('(');
		while (st != -1) {
			int st2 = toExecute.indexOf(')',st);
			while (true) {
				for (int i = st+1; i < st2; i++) {
					if (toExecute.charAt(i)=='+') {
						value=evaluate(toExecute.substring(st+1,i),x,value)+evaluate(toExecute.substring(i+1,st2),x,value);
						boolean charCheck = toExecute.charAt(i+1) == 'y' || toExecute.charAt(i+1) == 'x';
						toExecute = new String(toExecute.substring(0,st+1)+"y"+toExecute.substring(i+1+(charCheck?1:Integer.toString(evaluate(toExecute.substring(i+1,st2),x,value)).length()),toExecute.length()));
						break;
					} else if (toExecute.charAt(i)=='-') {
						value=evaluate(toExecute.substring(st+1,i),x,value)-evaluate(toExecute.substring(i+1,st2),x,value);
						boolean charCheck = toExecute.charAt(i+1) == 'y' || toExecute.charAt(i+1) == 'x';
						toExecute = new String(toExecute.substring(0,st+1)+"y"+toExecute.substring(i+1+(charCheck?1:Integer.toString(evaluate(toExecute.substring(i+1,st2),x,value)).length()),toExecute.length()));
						break;
					} else if (toExecute.charAt(i)=='*') {
						value=evaluate(toExecute.substring(st+1,i),x,value)*evaluate(toExecute.substring(i+1,st2),x,value);
						boolean charCheck = toExecute.charAt(i+1) == 'y' || toExecute.charAt(i+1) == 'x';
						toExecute = new String(toExecute.substring(0,st+1)+"y"+toExecute.substring(i+1+(charCheck?1:Integer.toString(evaluate(toExecute.substring(i+1,st2),x,value)).length()),toExecute.length()));
						break;
					} else if (toExecute.charAt(i)=='^') {
						value=(int) Math.pow(evaluate(toExecute.substring(st+1,i),x,value),evaluate(toExecute.substring(i+1,st2),x,value));
						boolean charCheck = toExecute.charAt(i+1) == 'y' || toExecute.charAt(i+1) == 'x';
						toExecute = new String(toExecute.substring(0,st+1)+"y"+toExecute.substring(i+1+(charCheck?1:Integer.toString(evaluate(toExecute.substring(i+1,st2),x,value)).length()),toExecute.length()));
						break;
					} else if (toExecute.charAt(i)=='%') {
						value=evaluate(toExecute.substring(st+1,i),x,value)%evaluate(toExecute.substring(i+1,st2),x,value);
						boolean charCheck = toExecute.charAt(i+1) == 'y' || toExecute.charAt(i+1) == 'x';
						toExecute = new String(toExecute.substring(0,st+1)+"y"+toExecute.substring(i+1+(charCheck?1:Integer.toString(evaluate(toExecute.substring(i+1,st2),x,value)).length()),toExecute.length()));
						break;
					} else if (toExecute.charAt(i)=='/') {
						value=evaluate(toExecute.substring(st+1,i),x,value)/evaluate(toExecute.substring(i+1,st2),x,value);
						boolean charCheck = toExecute.charAt(i+1) == 'y' || toExecute.charAt(i+1) == 'x';
						toExecute = new String(toExecute.substring(0,st+1)+"y"+toExecute.substring(i+1+(charCheck?1:Integer.toString(evaluate(toExecute.substring(i+1,st2),x,value)).length()),toExecute.length()));
						break;
					} else if (toExecute.charAt(i)=='@') {
						value=(int) Math.sqrt(evaluate(toExecute.substring(st+1,i),x,value));
						toExecute = new String(toExecute.substring(0,st+1)+"y"+toExecute.substring(i+1,toExecute.length()));
						break;
					}
				}
				st2 = toExecute.indexOf(')',st);
				if (st2-st==2)
					break;
			}
			toExecute = new String(toExecute.substring(0,st)+"y"+toExecute.substring(st2+1,toExecute.length()));
			st = toExecute.lastIndexOf('(');
		}
		return (int)Math.abs(value);
	}
	
	public int evaluate(String toEval, int x, int y) {
		if (toEval.toLowerCase().charAt(0) == 'x')
			return x;
		else if (toEval.toLowerCase().charAt(0) == 'y')
			return y;
		else if (Character.isDigit(toEval.charAt(0))) {
			int i;
			for (i = 1; i < toEval.length(); i++)
				if (!Character.isDigit(toEval.charAt(i)))
					break;
			return Integer.parseInt(toEval.substring(0,i));
		} else if ((toEval.toLowerCase().charAt(0) == 'e') || toEval.toLowerCase().substring(0,2).equals("pi"))
			return 3;
		return 0;
	}
	
	public void helpDocs() {
		System.out.println("SCE (Standard Caesarian Encryption) & ECE (Enchanced Caesarian Encryption)"+System.lineSeparator()+"Suite Manual");
		System.out.println("");
		System.out.println("Calling methods:");
		System.out.println("");
		System.out.println("-d(ecryption) param : Means that the decryption method should be called."+System.lineSeparator()+"\"param\" specifies the type, ece & sce perspectively.");
		System.out.println("");
		System.out.println("-e(ncryption) param : Means that the encryption method should be called."+System.lineSeparator()+"\"param\" specifies the type, ece & sce perspectively.");
		System.out.println("");
		System.out.println("-bf(bruteforce) : Means that the bruteforce method should be called."+System.lineSeparator()+"Note that it only works for SCE encryption.");
		System.out.println("");
		System.out.println("Using parameters:");
		System.out.println("");
		System.out.println("-p(arameter) key : Evaluates what is contained in the key position for each"+System.lineSeparator()+"encryption/decryption type (f.e. if it is a function or a bipolar multiplier for ECE) and uses it.");
		System.out.println("");
		System.out.println("-ws(wordskip) : Only supported by SCE encrypting and decrypting methods. Allows you to skip certain words in the sentence.");
		System.out.println("");
		System.out.println("-cb(clipboard) : Copies the result of the operation to the clipboard.");
		System.out.println("");
		System.out.println("Press Enter to return to main program...");
		System.console().readLine();
	}
}