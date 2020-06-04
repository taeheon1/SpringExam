package org.kdea.mybatis;

import java.util.List;

public interface EmpDAO {
	List<Emp> list();

	Emp info(int empno);

	int insert(Emp emp);

	int update(Emp emp);

	int delete(int empno);
}