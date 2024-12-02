package behavioral.observer;

public interface Observer<T> {
	// 모든 메서드는 public abstract로 간주되며, 이를 명시적으로 적을 필요가 없음 
	void update(T val);

}
