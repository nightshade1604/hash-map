class node{
  int val;
  node next;
  int key;
  node(int key,int val){
    this.key = key;
    this.val = val;
    this.next = null;
  }
}

class HashMap{
  int m;
  node[] hasht;
  
  HashMap(int m){
    this.m = m;
    this.hasht = new node[m];
  }
  
  int hashf(int key){
    return (2*key)%this.m;
  }
  
  void put(int key,int val){
    int index = hashf(key);
    node newnode = new node(key,val);
    node head = hasht[index];
    node curr = head;
    while(curr!=null){
      if(curr.key == key){
        curr.val = val;
        return;
      }
      curr=curr.next;
    }
    newnode.next = hasht[index];
    hasht[index] = newnode;
  }
  
  int get(int key){
    int index = hashf(key);
    node head = hasht[index];
    node curr = head;
    while(curr!=null){
      if(curr.key==key){
        return curr.val;
      }
      curr=curr.next;
    }
    return -1;
  }
  
  void remove(int key){
    int index = hashf(key);
    node head = hasht[index];
    node curr = head;
    node prev = null;
    while(curr!=null){
      if(curr.key == key && curr==head){
        hasht[index]=head.next;
        return;
      }
      else if(curr.key == key){
          prev.next=curr.next;
          return;
        }
      }
      prev = curr;
      curr = curr.next;
    }
  
  void display(){
        System.out.print("{");
        for (int i = 0; i < m; i++) {
            node curr = hasht[i];
            while (curr != null) {
                System.out.print(curr.key + ":" + curr.val + "; ");
                curr = curr.next;
            }
        }
        System.out.println("}");
    }
    public static void main(String[] args) {
        HashMap map = new HashMap(10);
        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);
        map.put(2, 25); // Updating value for key 2
        map.put(12, 40); // This will collide with key 2 in bucket 4
        
        System.out.println("Value for key 2: " + map.get(2));
        System.out.println("Value for key 12: " + map.get(12));
        
        map.display(); // Print the hash map for visualization
        
        map.remove(2);
        map.display(); // Check after removing key 2
    }
}

