// O ( nlogn)
//파티션이 낱개가 될때 까지 쪼개 진다.
//n번호출 한번 호출당 검색해야 할 데이터 양이 줄어드니 log n
//logn은 검색 영역이 절반찍 떨어진다.현재 머지 소트는 물리적으로
//가운데 값으로 하기 때문에 최악의 경우 nlogn이 된다.
public class Sort_Merge {
    public static void mergeSort(int[] arr){
        //정렬할 배열을 인자로 받는다.
        int[] tmp = new int[arr.length];
        //배열의 크기만큼 임시 저장소를 만든다.
        mergeSort(arr,tmp,0,arr.length-1);
        //시작과 끝 인덱스를 만들어 재귀함수를 만든다.
    }
    public static void mergeSort(int[] arr, int[] tmp, int start,int end){
        if(start < end){
            int mid = (start + end) / 2;
            mergeSort(arr, tmp, start, mid);
            mergeSort(arr, tmp, mid+1, end);
            merge(arr,tmp,start,mid,end);
        }
    } 
    public static void merge(int[] arr, int[] tmp, int start, int mid, int end){
        //임시 저장소에 필요한 만큼 복사를 한다.
        for(int i=start ; i<=end; i++){
            tmp[i] = arr[i];
        }
        int part1 = start; // 첫번째 방의 인덱스를 파트2개로 나눔
        int part2 = mid + 1; // 중간기준을 기준으로
        int index = start; // 양쪽방에 작은값을 하나씩 복사할때마다 결과 배열방 어디에 저장할지 알아야하니 복사 후 하나 씩 늘려 다음에 저장할 곳을 기억해야한다.
        while (part1 <= mid && part2 <= end){
            if(tmp[part1] <= tmp[part2]) {
                arr[index] = tmp[part1];
                part1++;
            }else{
                arr[index] = tmp[part2];
                part2++;
            }
            index++;
        }
        for(int i = 0; i<= mid - part1; i++){
            arr[index+i] = tmp[part1+i];
        }
    }
    public static void printArray(int[] arr){
        System.out.println();
        for (int data: arr
             ) {
            System.out.print(data+ " ");

        }
    }
    public static void main(String[] args) {
        int[] array = {4,2,6,3,7,8,5,1};
        printArray(array);
        mergeSort(array);
        printArray(array);
    }
}
