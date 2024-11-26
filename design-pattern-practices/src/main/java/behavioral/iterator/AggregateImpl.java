package behavioral.iterator;

public class AggregateImpl<E> implements Aggregate {

	private E[] datas = null;

	public AggregateImpl(E[] datas) {
		this.datas = datas;
	}

	@Override
	public Iterator<E> createIterator() {
		return new IteratorImpl();
	}

	// 내부 클래스 작성 -> datas 접근 가능
	private class IteratorImpl implements Iterator<E> {
		private int index = 0;

		@Override
		public E next() {
			return index < datas.length ? datas[index++] : null;
		}

		@Override
		public boolean hasNext() {
			return index < datas.length;
		}

	}

}
