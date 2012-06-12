/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filexmltest;

import javax.xml.parsers.ParserConfigurationException;
import org.jdom2.JDOMException;
import org.xml.sax.SAXException;
import java.io.*; 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
/**
 *
 * @author dell
 */
public class FileXmlTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, JDOMException {
        SAXBuilder builder = new SAXBuilder(); 
        Document doc = builder.build(new File("F:\\quiz.xml")); 
        Element root = doc.getRootElement();
        List<Map<String, ?>> items = new ArrayList<Map<String, ?>>();
        List<Element> root_cnl = root.getChildren();
        //遍历root_nl,把每个结果放入quizs
        for(int i=0;i<root_cnl.size();i++){
            //每个子节点是一个quiz
            Element quiz = root_cnl.get(i);
            //每个子节点存入一个Map<String , Object>
            Map<String , Object> item = new HashMap<String, Object>();
            //获取所有quiz的子节点
            List<Element> quiz_cnl = quiz.getChildren();
            for(int j=0;j<quiz_cnl.size();j++){
                //获取单个属性
                Element attr = quiz_cnl.get(j);
                //读取单个属性的名称
                String attr_name = attr.getName();
                
                //如果属性名称是id
                if(attr_name.equals("id")){                    
                    item.put("id", attr.getValue());
                }
                
                //如果属性名称是quiz_info
                else if(attr_name.equals("quiz_info")){                   
                    //存储quiz_info下子属性
                    Map<String , String> quiz_info = new HashMap<String, String>();
                    //获取quiz_info的子节点
                    List<Element> quiz_info_cnl = attr.getChildren();
                    //遍历quiz_info的子节点
                    for(int k=0;k<quiz_info_cnl.size();k++){
                        //将每个quiz_info 的子属性放入一个Map中
                        quiz_info.put(quiz_info_cnl.get(k).getName(), quiz_info_cnl.get(k).getValue());
                    }     
                    item.put("quiz_info", quiz_info);
                }
                
                //如果属性名称是description
                else if(attr_name.equals("description")){                    
                    item.put("description", attr.getValue());
                }
                
                //如果属性是attachments
                else if(attr_name.equals("attachments")){
                    List<Map<String ,?>> attachments = new ArrayList<Map<String, ?>>();
                    List<Element> attr_cnl = attr.getChildren();
                    //遍历attachments的子节点，每个是一个attachment
                    for(int k=0;k<attr_cnl.size();k++){
                        //每个attachment是一个Map
                        Map<String , Object> attachment = new HashMap<String , Object>();
                        //获取每个attachment的子节点
                        List<Element> attachment_cnl = attr_cnl.get(k).getChildren();
                        //遍历attachment的子节点
                        for(int m=0;m<attachment_cnl.size();m++){
                            //把attachment的子属性添加到相应Map
                            attachment.put(attachment_cnl.get(m).getName(), attachment_cnl.get(m).getValue());
                        }
                        //添加attachments的每个相同的子节点（标签名相同）
                        attachments.add(attachment);
                    }
                    item.put("attachments", attachments);
                }
                
                //如果属性名是correct_answer
                else if(attr_name.equals("correct_answer")){
                    List<Map<String ,?>> correct_answer = new ArrayList<Map<String, ?>>();
                    List<Element> attr_cnl = attr.getChildren();
                    //遍历correct_answer的子节点，每个是一个answer
                    for(int k=0;k<attr_cnl.size();k++){
                        //每个answer是一个Map
                        Map<String , Object> answer = new HashMap<String , Object>();
                        //获取每个answer的子节点
                        List<Element> answer_cnl = attr_cnl.get(k).getChildren();
                        //遍历answer的子节点
                        for(int m=0;m<answer_cnl.size();m++){
                            //把answer的子属性添加到相应Map
                            answer.put(answer_cnl.get(m).getName(), answer_cnl.get(m).getValue());
                        }
                        //添加correct_answer的每个相同的子节点answer（标签名相同）
                        correct_answer.add(answer);
                    }
                    item.put("correct_answer", correct_answer);    
                }
                
                //如果属性是wrong_answer
                else if(attr_name.equals("wrong_answer")){
                    List<Map<String ,?>> wrong_answer = new ArrayList<Map<String, ?>>();
                    List<Element> attr_cnl = attr.getChildren();
                    //遍历wrong_answer的子节点，每个是一个answer
                    for(int k=0;k<attr_cnl.size();k++){
                        //每个answer是一个Map
                        Map<String , Object> answer = new HashMap<String , Object>();
                        //获取每个answer的子节点
                        List<Element> answer_cnl = attr_cnl.get(k).getChildren();
                        //遍历answer的子节点
                        for(int m=0;m<answer_cnl.size();m++){
                            //把answer的子属性添加到相应Map
                            answer.put(answer_cnl.get(m).getName(), answer_cnl.get(m).getValue());
                        }
                        //添加wrong_answer的每个相同的子节点answer（标签名相同）
                        wrong_answer.add(answer);
                    }
                    item.put("wrong_answer", wrong_answer);          
                }
                
                //如果属性是manual_difficulty
                else if(attr_name.equals("manual_difficulty")){
                    item.put("manual_difficulty", attr.getValue());
                }
                
                //如果属性是auto_difficulty
                else if(attr_name.equals("auto_difficulty")){
                    item.put("auto_difficulty", attr.getValue());
                }
                
                //如果属性是tags
                else if(attr_name.equals("tags")){
                    //将所有的tag放入一个List中
                    List<String> tags = new ArrayList();
                    List<Element> tags_cnl = attr.getChildren();
                    for(int m=0;m<tags_cnl.size();m++){
                        tags.add(tags_cnl.get(m).getValue());
                    }
                    item.put("tags", tags);
                }            
            }            
            //将每个item添加到最终的数据结构
            items.add(item);
            
        }
    }
       
}
