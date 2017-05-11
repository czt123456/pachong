package com.czt.mytxt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReadFiles {
	public static void main(String args[]) throws SQLException, IOException {

		// 生成1~5的随机数
		// for(int i=0;i<10;i++){
		// System.out.println((int)(Math.random()*5)+1);
		// }
		String fileName = "D:\\duqu1\\真题\\语言";
		File file = new File(fileName);

		// ReadFiles.readManyFiles(file);
		readTureQuestion(file, fileName);

	}

	private static void readTureQuestion(File file, String myfile1) throws IOException {

		DButil dbutil = new DButil();

		InputStreamReader in = null;
		BufferedReader br = null;
		String b = null;
		StringBuffer sb = null;
		String s = null;
		System.out.println("父目录：" + file.getName());
		File[] filen = file.listFiles();
		for (int i = 0; i < filen.length; i++) {
			if (filen[i].isDirectory()) {

				System.out.println("子文件夹名字：" + filen[i].getName());
				String myfile = null;
				myfile = myfile1 + "\\" + filen[i].getName();
				File newFile = new File(myfile);
				System.out.println("子文件所在文件夹：" + myfile);
				File[] filen1 = newFile.listFiles();
				for (int j = 0; j < filen1.length; j++) {
					if (filen1[j].isFile()) {
						if (filen1[j].getName().endsWith("_答案.data")) {
							System.out.println("文件名：" + filen1[j].getName());

							in = new InputStreamReader(new FileInputStream(filen1[j]), "utf-8");
							br = new BufferedReader(in);
							sb = new StringBuffer();
							while ((b = br.readLine()) != null) {
								if (b.length() > 2 && b.substring(0, 1).equals("第")
										&& b.substring(b.length() - 1, b.length()).equals("题")) {
									sb.append("czt" + b);
								} else {
									sb.append(b);
								}

							}
							List<String> list = new ArrayList<String>();
							String str = sb.toString();
							String[] bb = str.split("czt");
							for (int c = 1; c < bb.length; c++) {
								list.add(bb[c]);
							}
							// System.out.println(list);
							// String oneRecord="第1题"+bb[1];
							// float aa=(float) ((int)(a/2)+a/2<a?a/2+0.5:a/2);

							for (int e = 0; e < filen1.length; e++) {
								if (filen1[e].isFile()) {
									if (!filen1[e].getName().endsWith("_答案.data")
											&& filen1[e].getName().equals(filen1[j].getName().replace("_答案", ""))) {
										System.out.println(filen1[e].getName());
										in = new InputStreamReader(new FileInputStream(filen1[e]), "utf-8");
										br = new BufferedReader(in);
										sb = new StringBuffer();
										String g;
										while((g=br.readLine())!=null){
											System.out.println(g);
										}
									}
								}
							}

						}
					}
				}
			}

			
		}
	}

	/**
	 * 读取多文件
	 * 
	 * @param file
	 * @throws SQLException
	 */
	private static void readManyFiles(File file) throws SQLException {
		// TODO Auto-generated method stub

		DButil dbutil = new DButil();

		InputStreamReader in = null;
		BufferedReader br = null;
		String b = null;
		StringBuffer sb = null;
		String s = null;
		File[] filen = file.listFiles();
		for (int i = 0; i < filen.length; i++) {
			if (filen[i].isFile()) {
				if (filen[i].getName().endsWith(".txt")) {
					System.out.println(filen[i].getName());
					try {
						in = new InputStreamReader(new FileInputStream(filen[i]), "utf-8");
						br = new BufferedReader(in);

						try {
							// int m=1;
							sb = new StringBuffer();
							while ((b = br.readLine()) != null) {
								sb.append(b + "czt");
								// m++;
							}
							s = sb.toString();
							System.out.println(s);
							String[] ss = s.split("cztcztczt ");
							System.out.println(ss.length);
							for (int j = 0; j < ss.length; j++) {
								if (!ss[j].equals("")) {
									// System.out.println(ss[j]);
									String[] sss = ss[j].split("cztczt");
									// System.out.println(sss.length);
									if (sss.length == 3) {
										String question = sss[1];
										/**
										 * 去掉多余的czt
										 */
										question = question.replace("czt", "");
										String answer = sss[2];
										String[] ssss = sss[2].split("czt");
										// System.out.println(ssss.length);
										if (ssss.length == 4) {
											String ans1 = ssss[0];
											String ans2 = ssss[1];
											String ans3 = ssss[2];
											String ans4 = ssss[3];

											Question question1 = new Question();
											question1.setQuestion(question);
											question1.setAns1(ans1);
											question1.setAns2(ans2);
											question1.setAns3(ans3);
											question1.setAns4(ans4);

											dbutil.addRcorder(question1);

											System.out.println("question:" + question + " ans1:" + ans1 + " ans2:"
													+ ans2 + " ans3:" + ans3 + " ans4:" + ans4);
										}
									}
								}
							}
							in.close();
							br.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		}
	}

}
