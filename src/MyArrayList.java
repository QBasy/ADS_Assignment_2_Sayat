import java.util.Arrays;

public class MyArrayList<A> implements MyList<A>
{
    private Object[] elements;
    private int size;

    public MyArrayList()
    {
        elements = new Object[10];
        size = 0;
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public boolean contains(Object o)
    {
        for (int i = 0; i < size; i++)
        {
            if (o.equals(elements[i]))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(A item)
    {
        if (size == elements.length)
        {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        elements[size] = item;
        size++;
    }

    @Override
    public void add(A item, int index)
    {
        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException();
        }
        if (size == elements.length)
        {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = item;
        size++;
    }

    @Override
    public boolean remove(A item)
    {
        for (int i = 0; i < size; i++)
        {
            if (item.equals(elements[i]))
            {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public A remove(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException();
        }
        A removedItem = (A) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
        elements[size] = null;
        return removedItem;
    }

    @Override
    public void clear()
    {
        Arrays.fill(elements, null);
        size = 0;
    }

    @Override
    public A get(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException();
        }
        return (A) elements[index];
    }

    @Override
    public int indexOf(Object o)
    {
        for (int i = 0; i < size; i++)
        {
            if (o.equals(elements[i]))
            {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o)
    {
        for (int i = size - 1; i >= 0; i--)
        {
            if (o.equals(elements[i]))
            {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void sort()
    {
        Arrays.sort(Arrays.copyOf(elements, size));
    }

}
