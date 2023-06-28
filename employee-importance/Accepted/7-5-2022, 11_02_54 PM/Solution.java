// https://leetcode.com/problems/employee-importance

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int ans=0;
        List<Integer> subs=new ArrayList<>();
        for(Employee i:employees){
            if(i.id==id){
                ans+=i.importance;
                for(Integer j:i.subordinates){
                    subs.add(j);
                }
               
                
                
            }
        }
        for(Integer k:subs){
            ans+=getImportance(employees,k);
        }
        
        
        
       return ans; 
    }
}